-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
-- Dec 22, 2015 9:38:23 AM ICT
UPDATE AD_Field SET DisplayLogic=NULL,Updated=TO_TIMESTAMP('2015-12-22 09:38:23','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=54402
;

-- Dec 22, 2015 9:38:42 AM ICT
UPDATE AD_Field SET DisplayLogic=NULL,Updated=TO_TIMESTAMP('2015-12-22 09:38:42','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=54401
;

-- Dec 22, 2015 9:33:32 AM ICT
INSERT INTO AD_Val_Rule (AD_Val_Rule_ID,Name,Description,Type,Code,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,EntityType,AD_Val_Rule_UU) VALUES (1000004,'Clear Validate','Use to override a validate with empty validate','S','1=1',0,0,'Y',TO_TIMESTAMP('2015-12-22 09:33:32','YYYY-MM-DD HH24:MI:SS'),100,TO_TIMESTAMP('2015-12-22 09:33:32','YYYY-MM-DD HH24:MI:SS'),100,'D','f4bf98d0-5395-409f-9bf5-4df74ba0a425')
;
SELECT register_migration_script('201522121604-IDEMPIERE-2982.sql') FROM dual
;

