#!/usr/bin/env python3
import argparse
import glob
import re
import sys
import xml.etree.ElementTree as ET


def parse_time_minutes(path_pattern: str) -> float:
    total_seconds = 0.0
    for file_path in glob.glob(path_pattern, recursive=True):
        try:
            root = ET.parse(file_path).getroot()
            total_seconds += float(root.attrib.get("time", "0"))
        except Exception:
            continue
    return total_seconds / 60.0


def main() -> int:
    parser = argparse.ArgumentParser(description="Simple CI quality gate checker")
    parser.add_argument("--smoke-max-minutes", type=float, default=15.0)
    parser.add_argument("--regression-max-minutes", type=float, default=120.0)
    parser.add_argument("--flaky-max-rate", type=float, default=0.03)
    args = parser.parse_args()

    smoke_minutes = parse_time_minutes("**/target/surefire-reports/TEST-*.xml")
    regression_minutes = smoke_minutes

    # Basic flaky proxy: rerun markers in surefire txt logs.
    flaky_markers = 0
    test_count = 0
    for file_path in glob.glob("**/target/surefire-reports/*.txt", recursive=True):
        content = open(file_path, encoding="utf-8", errors="ignore").read()
        flaky_markers += len(re.findall(r"Flaky|rerun|retry", content, flags=re.IGNORECASE))
        test_count += len(re.findall(r"Tests run:", content))
    flaky_rate = (flaky_markers / test_count) if test_count else 0.0

    print(f"smoke_minutes={smoke_minutes:.2f}")
    print(f"regression_minutes={regression_minutes:.2f}")
    print(f"flaky_rate={flaky_rate:.4f}")

    failed = False
    if smoke_minutes > args.smoke_max_minutes:
        print(f"FAIL: smoke exceeded {args.smoke_max_minutes}m")
        failed = True
    if regression_minutes > args.regression_max_minutes:
        print(f"FAIL: regression exceeded {args.regression_max_minutes}m")
        failed = True
    if flaky_rate > args.flaky_max_rate:
        print(f"FAIL: flaky rate exceeded {args.flaky_max_rate:.2%}")
        failed = True

    if failed:
        return 1
    print("Quality gate passed.")
    return 0


if __name__ == "__main__":
    sys.exit(main())
