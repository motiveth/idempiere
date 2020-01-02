-- Feb 9, 2014 7:26:22 PM ICT
-- I forgot to set the DICTIONARY_ID_COMMENTS System Configurator
UPDATE AD_Tab SET DisplayLogic='@C_Invoice_ID@=0&@C_Order_ID@=0&@C_Charge_ID@=0',Updated=TO_TIMESTAMP('2014-02-09 19:26:22','YYYY-MM-DD HH24:MI:SS'),UpdatedBy=100 WHERE AD_Tab_ID=755
;

SELECT register_migration_script('201401091604-IDEMPIERE-1740.sql') FROM dual
;