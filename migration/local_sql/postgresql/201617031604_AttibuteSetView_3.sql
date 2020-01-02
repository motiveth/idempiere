-- View: m_asi_v: allow user select attribute already input from order, receipt,..

DROP VIEW IF EXISTS m_asi_v;
-- View: m_asi_v

CREATE OR REPLACE VIEW m_asi_v AS 
 SELECT asi.m_attributesetinstance_id,
    p.m_product_id,
    asi.ad_client_id,
    asi.ad_org_id,
    asi.isactive,
    asi.m_attributeset_id,
    asi.serno,
    asi.lot,
    asi.guaranteedate,
    asi.description,
    asi.m_lot_id
   FROM m_attributesetinstance asi
     JOIN m_product p ON p.m_attributeset_id = asi.m_attributeset_id;

ALTER TABLE m_asi_v
  OWNER TO adempiere;

SELECT register_migration_script('201617031604_AttibuteSetView_3.sql') FROM dual
;
