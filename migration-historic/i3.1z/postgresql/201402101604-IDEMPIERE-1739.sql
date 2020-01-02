-- Feb 10, 2014 12:24:28 AM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
INSERT INTO AD_Column (SeqNoSelection,IsSyncDatabase,Version,AD_Column_ID,IsMandatory,IsTranslated,IsIdentifier,SeqNo,IsParent,FieldLength,IsSelectionColumn,IsKey,IsAutocomplete,IsAllowLogging,AD_Column_UU,IsUpdateable,ColumnName,Description,ColumnSQL,DefaultValue,Help,Name,IsAllowCopy,Updated,CreatedBy,AD_Org_ID,IsActive,Created,UpdatedBy,IsToolbarButton,IsAlwaysUpdateable,AD_Client_ID,EntityType,IsEncrypted,IsSecure,AD_Element_ID,AD_Reference_ID,AD_Table_ID) VALUES (0,'N',0,1000034,'N','N','N',0,'N',10,'N','N','N','Y','9f16c7ef-fb1b-4dc0-bf0f-f941a7c8f6df','N','NumLines','Number of lines for a field','(SELECT COUNT (*) FROM C_PaymentAllocate WHERE C_PaymentAllocate.C_Payment_ID = C_Payment.C_Payment_ID)',NULL,'Number of lines for a field','Number of Lines','N',TO_TIMESTAMP('2014-02-10 00:24:27','YYYY-MM-DD HH24:MI:SS'),100,0,'Y',TO_TIMESTAMP('2014-02-10 00:24:27','YYYY-MM-DD HH24:MI:SS'),100,'N','N',0,'D','N','N',200099,11,335)
;

-- Feb 10, 2014 12:25:24 AM ICT
INSERT INTO AD_Field (SortNo,IsEncrypted,AD_Tab_ID,DisplayLength,IsSameLine,IsHeading,SeqNo,IsCentrallyMaintained,AD_Field_ID,IsReadOnly,Help,DisplayLogic,Description,Name,AD_Field_UU,IsDisplayed,IsFieldOnly,UpdatedBy,AD_Org_ID,Created,CreatedBy,Updated,IsActive,IsDisplayedGrid,SeqNoGrid,XPosition,IsQuickEntry,AD_Client_ID,ColumnSpan,NumLines,IsAdvancedField,IsDefaultFocus,AD_Column_ID,EntityType) VALUES (0,'N',330,0,'N','N',740,'Y',1000031,'N','Number of lines for a field','1=2','Number of lines for a field','Number of Lines','bbd7af1d-5fd1-422d-8828-7c767a644ba3','Y','N',100,0,TO_TIMESTAMP('2014-02-10 00:25:24','YYYY-MM-DD HH24:MI:SS'),100,TO_TIMESTAMP('2014-02-10 00:25:24','YYYY-MM-DD HH24:MI:SS'),'Y','Y',740,1,'N',0,1,1,'N','N',1000034,'D')
;

-- Feb 10, 2014 12:26:51 AM ICT
UPDATE AD_Field SET ReadOnlyLogic='@NumLines@>0',Updated=TO_TIMESTAMP('2014-02-10 00:26:51','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=4257
;

-- Feb 10, 2014 12:27:20 AM ICT
UPDATE AD_Field SET ReadOnlyLogic='@NumLines@>0',Updated=TO_TIMESTAMP('2014-02-10 00:27:20','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=10902
;

-- Feb 10, 2014 12:27:53 AM ICT
UPDATE AD_Field SET ReadOnlyLogic='@NumLines@>0',Updated=TO_TIMESTAMP('2014-02-10 00:27:53','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=6969
;

SELECT register_migration_script('201402101604-IDEMPIERE-1739.sql') FROM dual
;