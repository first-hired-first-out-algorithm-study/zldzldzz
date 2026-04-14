-- 코드를 입력하세요
SELECT ROUND(sum(daily_fee)/count(car_id),0) as AVERAGE_FEE from CAR_RENTAL_COMPANY_CAR
where CAR_TYPE = "SUV";