#!/bin/bash

BASE=$1

unzip o -q "$BASE/inventory-service-*.jar" -d "$BASE"

exec java -javaagent:/urs/local/opentelemetry-java/opentelemetry-javaagent-v1.12.0.jar \
      -cp $BASE/BOOT-INF/classes:$BASE/BOOT-INF/lib/* com.inventory.inventoryService.InventoryServiceApplication