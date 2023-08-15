--liquibase formatted sql
--changeset thang.vuduc:add api gateway configuration
--validCheckSum ANY


INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value", "is_public") VALUES ('sb-gateway-api', 'default', 'default', 'server.port', '8080', 'false');
INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value", "is_public") VALUES ('sb-gateway-api', 'default', 'default', 'management.endpoint.health.enabled', 'true', 'false');
INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value", "is_public") VALUES ('sb-gateway-api', 'default', 'default', 'management.endpoint.info.enabled', 'true', 'false');
INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value") VALUES ('sb-gateway-api', 'default', 'default', 'spring.cloud.gateway.routes[0].id', 'sb-users-services');
INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value") VALUES ('sb-gateway-api', 'default', 'default', 'spring.cloud.gateway.routes[0].predicates[0]', 'Path=/sb-users-services/**');
INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value") VALUES ('sb-gateway-api', 'default', 'default', 'spring.cloud.gateway.routes[0].uri', 'http://localhost:8081/sb-users-services');
INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value") VALUES ('sb-gateway-api', 'default', 'default', 'spring.cloud.gateway.routes[1].id', 'sb-product-services');
INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value") VALUES ('sb-gateway-api', 'default', 'default', 'spring.cloud.gateway.routes[1].predicates[1]', 'Path=/sb-product-services/**');
INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value") VALUES ('sb-gateway-api', 'default', 'default', 'spring.cloud.gateway.routes[1].uri', 'http://localhost:8082/sb-product-services');
INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value") VALUES ('sb-gateway-api', 'default', 'default', 'spring.cloud.gateway.routes[2].id', 'sb-scheduler-services');
INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value") VALUES ('sb-gateway-api', 'default', 'default', 'spring.cloud.gateway.routes[2].predicates[2]', 'Path=/sb-scheduler-services/**');
INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value") VALUES ('sb-gateway-api', 'default', 'default', 'spring.cloud.gateway.routes[2].uri', 'http://localhost:8083/sb-scheduler-services');
INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value") VALUES ('sb-gateway-api', 'default', 'default', 'spring.cloud.gateway.routes[3].id', 'sb-commons-services');
INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value") VALUES ('sb-gateway-api', 'default', 'default', 'spring.cloud.gateway.routes[3].predicates[3]', 'Path=/sb-commons-services/**');
INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value") VALUES ('sb-gateway-api', 'default', 'default', 'spring.cloud.gateway.routes[3].uri', 'http://localhost:8084/sb-commons-services');

--rollback DELETE FROM "sbmaster"."configuration" WHERE "application" = 'sb-gateway-api';