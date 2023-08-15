--liquibase formatted sql
--changeset thang.vuduc:add scheduler services configuration
--validCheckSum ANY


INSERT INTO "sbmaster"."configuration"("application", "profile", "label", "key", "value", "is_public") VALUES ('sb-scheduler-services', 'default', 'default', 'server.port', '8083', 'false');

--rollback DELETE FROM "sbmaster"."configuration" WHERE "application" = 'sb-scheduler-services';