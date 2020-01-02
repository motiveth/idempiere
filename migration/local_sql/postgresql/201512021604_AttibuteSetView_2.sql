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
     JOIN m_product p ON p.m_attributeset_id = asi.m_attributeset_id
     JOIN ( SELECT DISTINCT ai.m_attributesetinstance_id
           FROM m_attributeinstance ai
             JOIN m_attribute a ON a.m_attribute_id = ai.m_attribute_id AND a.isinstanceattribute = 'Y'::bpchar) asikey ON asikey.m_attributesetinstance_id = asi.m_attributesetinstance_id;

ALTER TABLE m_asi_v
  OWNER TO adempiere;

SELECT register_migration_script('201512021604_AttibuteSetView_2.sql') FROM dual
;
