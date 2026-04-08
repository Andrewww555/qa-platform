import http from "k6/http";
import { check, sleep } from "k6";

export const options = {
  vus: 5,
  duration: "30s",
  thresholds: {
    http_req_failed: ["rate<0.02"],
    http_req_duration: ["p(95)<700", "p(99)<1200"],
  },
};

const baseUrl = __ENV.BASE_URL || "https://restful-booker.herokuapp.com";

export default function () {
  const res = http.get(`${baseUrl}/booking`);
  check(res, {
    "status is 200": (r) => r.status === 200,
  });
  sleep(1);
}
