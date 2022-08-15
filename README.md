# 8/12 回家作業 --課堂作業改寫成 H2 Database + Spring Data JPA
* Database 中 Order 和 Meal 的資料表中都已先存入幾筆資料 (data.sql)
* Table :
  * Order : id/seq(訂單編號)/totalPrice(訂單總額)/waiter(服務人員)/mealId(餐點編號)/quan(餐點數量)
  * Meal  : id(餐點編號)/name(餐點名稱)/price(單價)/description(介紹)
* OrderService :
  * getAllOrders    : 取得所有訂單
  * getOrderById    : 藉由 id 找到特定的 Order
  * getOrderBySeq   : 藉由 seq 找到特定的 Order
  * createOrder     : 新增一筆 Order  
  * updateOrder     : 用 id 找到需要更新的 Order
  * deleteOrderById : 用 id 找到要刪除的 Order
  * totalPrice      : 計算每筆訂單的總金額
  * checkMealId     : 判斷輸入的 Meal 是否存在  
  讓 Order 輸入的 mealId 不在 Meal 時，會無法存入資料表
  * checkOrder      : 判斷同筆訂單是否有相同 Meal  
  當 Order 中，相同的 seq 要建立兩筆 相同的 mealId 時，會無法存入資料表
* OrderController :
  * getAllOrders    : 回傳所有訂單
  * getOrderById    : 回傳 id 找到的 Order  (只會有一筆)
  * getOrderBySeq   : 回傳 seq(訂單編號) 找到 Order 
  * createOrder     : 回傳 新增訂單成功 或 失敗原因  
  * updateOrder     : 回傳 更新訂單成功 或 失敗原因 
  * deleteOrderById : 回傳 刪除訂單成功 或 失敗原因 
