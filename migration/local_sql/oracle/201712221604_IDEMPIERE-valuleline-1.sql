SET SQLBLANKLINES ON
SET DEFINE OFF

-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
-- Dec 21, 2017 9:02:16 AM ICT
INSERT INTO AD_Column (AD_Column_ID,Version,Name,Description,Help,AD_Table_ID,ColumnName,FieldLength,IsKey,IsParent,IsMandatory,IsTranslated,IsIdentifier,SeqNo,IsEncrypted,AD_Reference_ID,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,AD_Element_ID,IsUpdateable,IsSelectionColumn,EntityType,IsSyncDatabase,IsAlwaysUpdateable,IsAutocomplete,IsAllowLogging,AD_Column_UU,IsAllowCopy,SeqNoSelection,IsToolbarButton,IsSecure) VALUES (1000555,0,'Search Key','Search key for the record in the format required - must be unique','A search key allows you a fast method of finding a particular record.
If you leave the search key empty, the system automatically creates a numeric number.  The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).',333,'Value',40,'N','N','N','N','N',0,'N',10,0,0,'Y',TO_DATE('2017-12-21 09:02:16','YYYY-MM-DD HH24:MI:SS'),100,TO_DATE('2017-12-21 09:02:16','YYYY-MM-DD HH24:MI:SS'),100,620,'Y','Y','U','N','N','N','Y','e4f7d35f-1152-448d-bf24-efc025e4758f','N',0,'N','N')
;

-- Dec 21, 2017 9:02:39 AM ICT
INSERT INTO AD_Column (AD_Column_ID,Version,Name,Description,Help,AD_Table_ID,ColumnName,FieldLength,IsKey,IsParent,IsMandatory,IsTranslated,IsIdentifier,SeqNo,IsEncrypted,AD_Reference_ID,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,AD_Element_ID,IsUpdateable,IsSelectionColumn,EntityType,IsSyncDatabase,IsAlwaysUpdateable,IsAutocomplete,IsAllowLogging,AD_Column_UU,IsAllowCopy,SeqNoSelection,IsToolbarButton,IsSecure) VALUES (1000556,0,'Search Key','Search key for the record in the format required - must be unique','A search key allows you a fast method of finding a particular record.
If you leave the search key empty, the system automatically creates a numeric number.  The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).',260,'Value',40,'N','N','N','N','N',0,'N',10,0,0,'Y',TO_DATE('2017-12-21 09:02:39','YYYY-MM-DD HH24:MI:SS'),100,TO_DATE('2017-12-21 09:02:39','YYYY-MM-DD HH24:MI:SS'),100,620,'Y','Y','U','N','N','N','Y','002b3e46-001f-4f9c-a816-996490700992','N',0,'N','N')
;

-- Dec 21, 2017 9:18:42 AM ICT
INSERT INTO AD_Column (AD_Column_ID,Version,Name,Description,Help,AD_Table_ID,ColumnName,FieldLength,IsKey,IsParent,IsMandatory,IsTranslated,IsIdentifier,SeqNo,IsEncrypted,AD_Reference_ID,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,AD_Element_ID,IsUpdateable,IsSelectionColumn,EntityType,IsSyncDatabase,IsAlwaysUpdateable,IsAutocomplete,IsAllowLogging,AD_Column_UU,IsAllowCopy,SeqNoSelection,IsToolbarButton,IsSecure) VALUES (1000557,0,'Search Key','Search key for the record in the format required - must be unique','A search key allows you a fast method of finding a particular record.
If you leave the search key empty, the system automatically creates a numeric number.  The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).',320,'Value',40,'N','N','N','N','N',0,'N',10,0,0,'Y',TO_DATE('2017-12-21 09:18:42','YYYY-MM-DD HH24:MI:SS'),100,TO_DATE('2017-12-21 09:18:42','YYYY-MM-DD HH24:MI:SS'),100,620,'Y','Y','U','N','N','N','Y','02f9afa4-526c-4c2a-af75-8cc6bdc2f1ee','N',0,'N','N')
;

-- Dec 21, 2017 9:21:16 AM ICT
ALTER TABLE C_OrderLine ADD Value VARCHAR2(40) DEFAULT NULL 
;

-- Dec 21, 2017 9:21:42 AM ICT
ALTER TABLE C_InvoiceLine ADD Value VARCHAR2(40) DEFAULT NULL 
;

-- Dec 21, 2017 9:22:01 AM ICT
ALTER TABLE M_InOutLine ADD Value VARCHAR2(40) DEFAULT NULL 
;

-- Dec 21, 2017 9:24:16 AM ICT
INSERT INTO AD_Field (AD_Field_ID,Name,Description,Help,AD_Tab_ID,AD_Column_ID,IsDisplayed,DisplayLength,SeqNo,SortNo,IsSameLine,IsHeading,IsFieldOnly,IsEncrypted,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,IsReadOnly,IsCentrallyMaintained,EntityType,AD_Field_UU,IsDisplayedGrid,SeqNoGrid,XPosition,ColumnSpan,NumLines,IsQuickEntry,IsDefaultFocus,IsAdvancedField) VALUES (1002843,'Search Key','Search key for the record in the format required - must be unique','A search key allows you a fast method of finding a particular record.
If you leave the search key empty, the system automatically creates a numeric number.  The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).',270,1000555,'Y',0,270,0,'N','N','N','N',0,0,'Y',TO_DATE('2017-12-21 09:24:16','YYYY-MM-DD HH24:MI:SS'),100,TO_DATE('2017-12-21 09:24:16','YYYY-MM-DD HH24:MI:SS'),100,'N','Y','U','ae5aa51c-58e2-4253-838a-3226f9741ff6','Y',270,1,1,1,'N','N','N')
;

-- Dec 21, 2017 9:24:58 AM ICT
UPDATE AD_Field SET SeqNo=220, AD_Reference_Value_ID=NULL, AD_Val_Rule_ID=NULL, ColumnSpan=2, IsToolbarButton=NULL,Updated=TO_DATE('2017-12-21 09:24:58','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1002843
;

-- Dec 21, 2017 9:24:58 AM ICT
UPDATE AD_Field SET SeqNo=0, AD_Reference_Value_ID=NULL, AD_Val_Rule_ID=NULL, IsToolbarButton=NULL,Updated=TO_DATE('2017-12-21 09:24:58','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=204739
;

-- Dec 21, 2017 9:25:48 AM ICT
INSERT INTO AD_Field (AD_Field_ID,Name,Description,Help,AD_Tab_ID,AD_Column_ID,IsDisplayed,DisplayLength,SeqNo,SortNo,IsSameLine,IsHeading,IsFieldOnly,IsEncrypted,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,IsReadOnly,IsCentrallyMaintained,EntityType,AD_Field_UU,IsDisplayedGrid,SeqNoGrid,XPosition,ColumnSpan,NumLines,IsQuickEntry,IsDefaultFocus,IsAdvancedField) VALUES (1002844,'Search Key','Search key for the record in the format required - must be unique','A search key allows you a fast method of finding a particular record.
If you leave the search key empty, the system automatically creates a numeric number.  The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).',291,1000555,'Y',0,330,0,'N','N','N','N',0,0,'Y',TO_DATE('2017-12-21 09:25:48','YYYY-MM-DD HH24:MI:SS'),100,TO_DATE('2017-12-21 09:25:48','YYYY-MM-DD HH24:MI:SS'),100,'N','Y','U','8c411cc3-97d9-416f-b0d5-3339b984eb54','Y',330,1,2,1,'N','N','N')
;

SET SQLBLANKLINES ON
SET DEFINE OFF

-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
-- Dec 21, 2017 7:24:40 PM ICT
INSERT INTO AD_Field (AD_Field_ID,Name,Description,Help,AD_Tab_ID,AD_Column_ID,IsDisplayed,DisplayLength,SeqNo,SortNo,IsSameLine,IsHeading,IsFieldOnly,IsEncrypted,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,IsReadOnly,IsCentrallyMaintained,EntityType,AD_Field_UU,IsDisplayedGrid,SeqNoGrid,XPosition,ColumnSpan,NumLines,IsQuickEntry,IsDefaultFocus,IsAdvancedField) VALUES (1002845,'Search Key','Search key for the record in the format required - must be unique','A search key allows you a fast method of finding a particular record.
If you leave the search key empty, the system automatically creates a numeric number.  The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).',1000058,1000555,'Y',0,270,0,'N','N','N','N',0,0,'Y',TO_DATE('2017-12-21 19:24:40','YYYY-MM-DD HH24:MI:SS'),100,TO_DATE('2017-12-21 19:24:40','YYYY-MM-DD HH24:MI:SS'),100,'N','Y','U','043b2d39-2388-4f53-8886-165fbc51a65b','Y',270,1,2,1,'N','N','N')
;

-- Dec 21, 2017 7:25:09 PM ICT
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=170, AD_Reference_Value_ID=NULL, AD_Val_Rule_ID=NULL, XPosition=1, IsToolbarButton=NULL,Updated=TO_DATE('2017-12-21 19:25:09','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1002845
;

-- Dec 21, 2017 7:25:09 PM ICT
UPDATE AD_Field SET SeqNo=180, AD_Reference_Value_ID=NULL, AD_Val_Rule_ID=NULL, IsToolbarButton=NULL,Updated=TO_DATE('2017-12-21 19:25:09','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1001505
;

-- Dec 21, 2017 7:25:47 PM ICT
INSERT INTO AD_Field (AD_Field_ID,Name,Description,Help,AD_Tab_ID,AD_Column_ID,IsDisplayed,DisplayLength,SeqNo,SortNo,IsSameLine,IsHeading,IsFieldOnly,IsEncrypted,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,IsReadOnly,IsCentrallyMaintained,EntityType,AD_Field_UU,IsDisplayedGrid,SeqNoGrid,XPosition,ColumnSpan,NumLines,IsQuickEntry,IsDefaultFocus,IsAdvancedField) VALUES (1002846,'Search Key','Search key for the record in the format required - must be unique','A search key allows you a fast method of finding a particular record.
If you leave the search key empty, the system automatically creates a numeric number.  The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).',1000087,1000555,'Y',0,330,0,'N','N','N','N',0,0,'Y',TO_DATE('2017-12-21 19:25:47','YYYY-MM-DD HH24:MI:SS'),100,TO_DATE('2017-12-21 19:25:47','YYYY-MM-DD HH24:MI:SS'),100,'N','Y','U','e70e4cfa-ed7e-4eb4-b190-3b0111e7f10e','Y',330,1,2,1,'N','N','N')
;

-- Dec 21, 2017 7:26:03 PM ICT
UPDATE AD_Field SET IsDisplayed='Y', SeqNo=190, AD_Reference_Value_ID=NULL, AD_Val_Rule_ID=NULL, XPosition=1, IsToolbarButton=NULL,Updated=TO_DATE('2017-12-21 19:26:03','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1002846
;

-- Dec 21, 2017 7:26:03 PM ICT
UPDATE AD_Field SET SeqNo=200, AD_Reference_Value_ID=NULL, AD_Val_Rule_ID=NULL, IsToolbarButton=NULL,Updated=TO_DATE('2017-12-21 19:26:03','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Field_ID=1002235
;

SELECT register_migration_script('201712221604_IDEMPIERE-valuleline-1.sql') FROM dual
;