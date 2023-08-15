--liquibase formatted sql
--changeset thang.vuduc:add product services configuration
--validCheckSum ANY


INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value", "is_public") VALUES ('sb-product-services', 'default', 'default', 'server.port', '8082', 'false');

--rollback DELETE FROM "sbmaster"."configuration" WHERE "application" = 'sb-product-services';