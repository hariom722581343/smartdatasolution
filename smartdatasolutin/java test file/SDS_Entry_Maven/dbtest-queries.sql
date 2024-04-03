-- Question 1: Find total claimed_charge of the exported documents.
SELECT SUM(claimed_charge) AS total_claimed_charge
FROM document
WHERE status = 'EXPORTED';

Answer--> total_claimed_charge
          3450



-- Question 2: Find insured_name, insured_address, and claimed_charge for the documents 
-- that have status "TO_REPRICE" and customer id 1 and 2.
SELECT insured_name, insured_address, claimed_charge
FROM document d
JOIN batch b ON d.batch_id = b.id
WHERE d.status = 'TO_REPRICE'
AND b.customer_id IN (1, 2);

Answer--> 
insured_name           	insured_address	    claimed_charge
Geeta	                        KTM             	11100
Shankar	                      KTM             	500
Shyam	                        NGT	             100
Biraj	                        KTM             	510
Shankar	                      NGT	             1500
Ujjwal	                       NGT	             80000
Bishwo	                       LALIT	           600
Ram	                          KTM             	100
Krishna	                      KTM             	110
