<template>
  <div class="container">
    <section>
      <h1>HELLO SHOP</h1>
    </section>
    <section>
      <p>회원기능</p>
      <section>
        <router-link to="/members/register">회원 가입</router-link>
        <router-link to="/members">회원 목록</router-link>
      </section>
    </section>

    <section>
      <p>상품기능</p>
      <section>
        <router-link to="/items/register">상품 등록</router-link>
        <router-link to="/items">상품 목록</router-link>
      </section>
    </section>

    <section>
    <p>주문 기능</p>
      <section>
        <router-link to="/order">상품 주문</router-link>
        <router-link to="/orders">주문 내역</router-link>
      </section>
    </section>

  </div>
</template>

<script>
export default {
  name: "MainPage"
}
</script>

<style scoped>
  .container {
    padding: 30px 0;
    background-color: #c0c0c0;
    display: flex;
    flex-direction: column;
    justify-content: center;
  }
</style>
