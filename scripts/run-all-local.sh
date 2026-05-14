#!/usr/bin/env bash
# Start Eureka first, then other services (they register with Eureka).
# Requires: Java 17+, MySQL with databases restaurantdb and userdb (see each module's application.yml).
set -euo pipefail
ROOT="$(cd "$(dirname "$0")/.." && pwd)"
cd "$ROOT"

echo "Starting Eureka on http://localhost:8761 ..."
(cd "$ROOT/eureka" && ./mvnw -q spring-boot:run) &
sleep 25

echo "Starting restaurantListing on http://localhost:9091 ..."
(cd "$ROOT/restaurantListing" && ./mvnw -q spring-boot:run) &

echo "Starting userInfo on http://localhost:9093 ..."
(cd "$ROOT/userInfo" && ./mvnw -q spring-boot:run) &

echo "Processes launched. Press Ctrl+C to stop this script (child apps may keep running)."
wait
