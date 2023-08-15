--liquibase formatted sql
--changeset thang.vuduc:add commons services configuration
--validCheckSum ANY


INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value", "is_public") VALUES ('sb-commons-services', 'default', 'default', 'server.port', '8084', 'false');

--rollback DELETE FROM "sbmaster"."configuration" WHERE "application" = 'sb-commons-services';