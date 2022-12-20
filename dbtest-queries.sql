SELECT sum(claimed_charge) AS total_claimed_charged
FROM document;

SELECT d.insured_name, d.insured_address, d.claimed_charge
FROM batch AS b
         JOIN document AS d
              ON b.id = d.batch_id
WHERE d.status = "TO_REPRICE"
  AND b.customer_id IN (1, 2);