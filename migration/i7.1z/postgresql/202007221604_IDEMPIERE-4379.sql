-- IDEMPIERE-4379: add parameter UseConfigFolder, StopOnError for process Apply Pack In from Folder
-- Jul 22, 2020, 12:15:22 PM ICT

-- Jul 22, 2020, 12:19:45 PM ICT
INSERT INTO AD_Process_Para (AD_Process_Para_ID,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,Name,AD_Process_ID,SeqNo,AD_Reference_ID,IsRange,FieldLength,IsMandatory,ColumnName,IsCentrallyMaintained,EntityType,AD_Process_Para_UU,IsEncrypted,IsAutocomplete) VALUES (5000001,0,0,'Y',TO_TIMESTAMP('2020-07-22 12:19:45','YYYY-MM-DD HH24:MI:SS'),100,TO_TIMESTAMP('2020-07-22 12:19:45','YYYY-MM-DD HH24:MI:SS'),100,'Use Folder On Configruation',200099,20,20,'N',0,'N','UseConfigFolder','N','D','80fb6e6d-af61-4506-af2c-acb967ff3e32','N','N')
;

-- Jul 22, 2020, 12:46:10 PM ICT
UPDATE AD_Process_Para SET DefaultValue='N',Updated=TO_TIMESTAMP('2020-07-22 12:46:10','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_Para_ID=5000001
;

-- Jul 22, 2020, 12:48:08 PM ICT
UPDATE AD_Process_Para SET IsMandatory='N', MandatoryLogic='@UseConfigFolder@=N',Updated=TO_TIMESTAMP('2020-07-22 12:48:08','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Process_Para_ID=200226
;

SELECT register_migration_script('202007221604_IDEMPIERE-4379.sql') FROM dual
;