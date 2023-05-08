<template>
  <div>
    <section>
      <input type="text" placeholder="회원명" v-model="inputMemberName"/>
      <select v-model="orderStatus">
        <option value="">주문 상태</option>
        <option value="ORDER">ORDER</option>
        <option value="CANCEL">CANCEL</option>
      </select>
      <button type="button" @click="search">검색</button>
    </section>
    <section class="header">
      <p>#</p>
      <p>회원명</p>
      <p>대표상품 이름</p>
      <p>대표상품 주문 가격</p>
      <p>대표상품 주문 수량</p>
      <p>상태</p>
      <p>일시</p>
    </section>
    <section v-for="order in orders" :key="order" class="item">
      <p>{{order.id}}</p>
      <p>{{order.memberName}}</p>
      <p>{{order.itemName}}</p>
      <p>{{order.price}}</p>
      <p>{{order.count}}</p>
      <p>{{order.orderStatus}}</p>
      <p>{{order.orderDate}}</p>
      <button v-if="order.orderStatus != 'CANCEL'" type="button" @click="cancel(order.id)">CANCEL</button>
    </section>
  </div>
</template>

<script>
export default {
  name: "OrderList"
}
</script>

<style scoped>

</style>