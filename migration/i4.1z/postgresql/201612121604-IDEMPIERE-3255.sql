-- I don't forgot to set the DICTIONARY_ID_COMMENTS System Configurator
-- Dec 12, 2016 2:35:56 PM ICT
INSERT INTO AD_SysConfig (AD_SysConfig_ID,AD_Client_ID,AD_Org_ID,Created,Updated,CreatedBy,UpdatedBy,IsActive,Name,Value,Description,EntityType,ConfigurationLevel,AD_SysConfig_UU) VALUES (200084,0,0,TO_TIMESTAMP('2016-12-12 14:35:55','YYYY-MM-DD HH24:MI:SS'),TO_TIMESTAMP('2016-12-12 14:35:55','YYYY-MM-DD HH24:MI:SS'),100,100,'Y','MAIL_USER_MANDATORY','Y','Y mean Have to configuration email for user to use sent mail function, let receive can reply to user. N mean use address sent mail like reply to','D','C','9d08eec7-fc88-46e7-9b93-27a04a3731ee')
;
SELECT register_migration_script('201612121604-IDEMPIERE-3255.sql') FROM dual
;
