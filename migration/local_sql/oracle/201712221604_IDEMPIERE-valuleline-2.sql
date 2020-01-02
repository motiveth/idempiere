SET SQLBLANKLINES ON
SET DEFINE OFF

-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
-- Dec 22, 2017 11:06:15 AM ICT
INSERT INTO AD_Field (AD_Field_ID,Name,Description,Help,AD_Tab_ID,AD_Column_ID,IsDisplayed,DisplayLength,SeqNo,SortNo,IsSameLine,IsHeading,IsFieldOnly,IsEncrypted,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,IsReadOnly,IsCentrallyMaintained,EntityType,AD_Field_UU,IsDisplayedGrid,SeqNoGrid,XPosition,ColumnSpan,NumLines,IsQuickEntry,IsDefaultFocus,IsAdvancedField) VALUES (1002847,'Search Key','Search key for the record in the format required - must be unique','A search key allows you a fast method of finding a particular record.
If you leave the search key empty, the system automatically creates a numeric number.  The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).',1000051,1000557,'Y',0,240,0,'N','N','N','N',0,0,'Y',TO_DATE('2017-12-22 11:06:15','YYYY-MM-DD HH24:MI:SS'),100,TO_DATE('2017-12-22 11:06:15','YYYY-MM-DD HH24:MI:SS'),100,'N','Y','U','b369af1d-cc3f-4704-89ae-f75f372dd0ae','Y',260,1,2,1,'N','N','N')
;

-- Dec 22, 2017 11:07:15 AM ICT
INSERT INTO AD_Field (AD_Field_ID,Name,Description,Help,AD_Tab_ID,AD_Column_ID,IsDisplayed,DisplayLength,SeqNo,SortNo,IsSameLine,IsHeading,IsFieldOnly,IsEncrypted,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,IsReadOnly,IsCentrallyMaintained,EntityType,AD_Field_UU,IsDisplayedGrid,SeqNoGrid,XPosition,ColumnSpan,NumLines,IsQuickEntry,IsDefaultFocus,IsAdvancedField) VALUES (1002848,'Search Key','Search key for the record in the format required - must be unique','A search key allows you a fast method of finding a particular record.
If you leave the search key empty, the system automatically creates a numeric number.  The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).',1000081,1000557,'Y',0,160,0,'N','N','N','N',0,0,'Y',TO_DATE('2017-12-22 11:07:15','YYYY-MM-DD HH24:MI:SS'),100,TO_DATE('2017-12-22 11:07:15','YYYY-MM-DD HH24:MI:SS'),100,'N','Y','U','4430c5ee-7d04-49c8-9b63-550134502bbc','Y',270,1,2,1,'N','N','N')
;

-- Dec 22, 2017 11:08:06 AM ICT
INSERT INTO AD_Field (AD_Field_ID,Name,Description,Help,AD_Tab_ID,AD_Column_ID,IsDisplayed,DisplayLength,SeqNo,SortNo,IsSameLine,IsHeading,IsFieldOnly,IsEncrypted,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,IsReadOnly,IsCentrallyMaintained,EntityType,AD_Field_UU,IsDisplayedGrid,SeqNoGrid,XPosition,ColumnSpan,NumLines,IsQuickEntry,IsDefaultFocus,IsAdvancedField) VALUES (1002849,'Search Key','Search key for the record in the format required - must be unique','A search key allows you a fast method of finding a particular record.
If you leave the search key empty, the system automatically creates a numeric number.  The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).',1000026,1000556,'Y',0,340,0,'N','N','N','N',0,0,'Y',TO_DATE('2017-12-22 11:08:06','YYYY-MM-DD HH24:MI:SS'),100,TO_DATE('2017-12-22 11:08:06','YYYY-MM-DD HH24:MI:SS'),100,'N','Y','U','505a2d88-8d4d-4cf3-b670-8a75db2c7317','Y',370,1,2,1,'N','N','N')
;

-- Dec 22, 2017 11:09:02 AM ICT
INSERT INTO AD_Field (AD_Field_ID,Name,Description,Help,AD_Tab_ID,AD_Column_ID,IsDisplayed,DisplayLength,SeqNo,SortNo,IsSameLine,IsHeading,IsFieldOnly,IsEncrypted,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,IsReadOnly,IsCentrallyMaintained,EntityType,AD_Field_UU,IsDisplayedGrid,SeqNoGrid,XPosition,ColumnSpan,NumLines,IsQuickEntry,IsDefaultFocus,IsAdvancedField) VALUES (1002850,'Search Key','Search key for the record in the format required - must be unique','A search key allows you a fast method of finding a particular record.
If you leave the search key empty, the system automatically creates a numeric number.  The document sequence used for this fallback number is defined in the "Maintain Sequence" window with the name "DocumentNo_<TableName>", where TableName is the actual name of the table (e.g. C_Order).',1000021,1000556,'Y',0,220,0,'N','N','N','N',0,0,'Y',TO_DATE('2017-12-22 11:09:02','YYYY-MM-DD HH24:MI:SS'),100,TO_DATE('2017-12-22 11:09:02','YYYY-MM-DD HH24:MI:SS'),100,'N','Y','U','1b81a5e8-939b-4406-aeec-4296083a18c9','Y',460,1,2,1,'N','N','N')
;

SELECT register_migration_script('201712221604_IDEMPIERE-valuleline-2.sql') FROM dual
;