--liquibase formatted sql
--changeset thang.vuduc:add users services configuration
--validCheckSum ANY


INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value", "is_public") VALUES ('sb-users-services', 'default', 'default', 'server.port', '8081', 'false');

--rollback DELETE FROM "sbmaster"."configuration" WHERE "application" = 'sb-users-services';