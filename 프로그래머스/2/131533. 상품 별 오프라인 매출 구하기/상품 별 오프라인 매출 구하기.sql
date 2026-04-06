-- 코드를 입력하세요
SELECT 
    p.PRODUCT_CODE,
    sum(p.PRICE*o.SALES_AMOUNT) AS SALES
from PRODUCT as p
join OFFLINE_SALE as o on o.PRODUCT_ID = p.PRODUCT_ID
group by p.PRODUCT_CODE
order by SALES desc, p.PRODUCT_CODE asc;