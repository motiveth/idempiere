-- IDEMPIERE-3487 add dynamic validate for price list version on info window
-- Sep 14, 2017 5:31:28 PM ICT
INSERT INTO AD_Val_Rule (AD_Val_Rule_ID,Name,Description,Type,Code,AD_Client_ID,AD_Org_ID,IsActive,Created,CreatedBy,Updated,UpdatedBy,EntityType,AD_Val_Rule_UU) VALUES (200110,'Price List Version Filter On Product Info','Filter out PLV of inactive price list and just got PLV of current price list','S','M_PriceList_Version.M_PriceList_ID IN (SELECT M_PriceList_ID FROM M_PriceList WHERE M_PriceList.isactive = ''Y'' AND (@0|M_PriceList_ID:-1@ = -1 OR M_PriceList.M_PriceList_ID = @0|M_PriceList_ID:-1@))',0,0,'Y',TO_TIMESTAMP('2017-09-14 17:31:28','YYYY-MM-DD HH24:MI:SS'),100,TO_TIMESTAMP('2017-09-14 17:31:28','YYYY-MM-DD HH24:MI:SS'),100,'D','67f5bee8-7d49-41b5-8c0e-a1245186a0a1')
;

-- Sep 14, 2017 5:31:37 PM ICT
UPDATE AD_InfoColumn SET AD_Val_Rule_ID=200110,Updated=TO_TIMESTAMP('2017-09-14 17:31:37','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_InfoColumn_ID=200009
;

SELECT register_migration_script('201709141604_IDEMPIERE-3487.sql') FROM dual
;
