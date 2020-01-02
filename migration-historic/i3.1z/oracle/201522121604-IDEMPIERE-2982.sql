SET SQLBLANKLINES ON
SET DEFINE OFF

-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
-- Dec 22, 2015 9:38:23 AM ICT
UPDATE AD_Field SET DisplayLogic=NULL,Updated=TO_DATE('2015-12-22 09:38:23','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=54402
;

-- Dec 22, 2015 9:38:42 AM ICT
UPDATE AD_Field SET DisplayLogic=NULL,Updated=TO_DATE('2015-12-22 09:38:42','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=54401
;

-- Dec 22, 2015 9:33:32 AM ICT
INSERT INTO AD_Val_Rule (AD_Val_Rule_ID,Name,Description,Type,Code,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,EntityType,AD_Val_Rule_UU) VALUES (200085,'Clear Validate','Use to override a validate with empty validate','S','1=1',0,0,'Y',TO_DATE('2015-12-22 11:06:28','YYYY-MM-DD HH24:MI:SS'),100,TO_DATE('2015-12-22 11:06:28','YYYY-MM-DD HH24:MI:SS'),100,'D','a2ef8df6-420d-4678-b000-ee906256c7e2')
;
SELECT register_migration_script('201522121604-IDEMPIERE-2982.sql') FROM dual
;
