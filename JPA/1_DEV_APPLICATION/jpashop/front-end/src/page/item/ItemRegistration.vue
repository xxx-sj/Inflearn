<template>
  <div>
    상품등록
    <hr />
    <form @submit.prevent="save">
      <p>상품명</p>
      <input type="text" v-model="name"/>
      <p>가격</p>
      <input type="number" v-model="price"/>
      <p>수량</p>
      <input type="number" v-model="stockQuantity"/>
      <p>저자</p>
      <input type="text" v-model="author"/>
      <p>ISBN</p>
      <input  type="text" v-model="isbn"/>
      <section>
        <button type="submit">등록</button>
      </section>
    </form>
  </div>
</template>

<script>
export default {
  name: "ItemRegistration",
  inject: ['axios'],

  data() {
    return {
      saveURL: `/rest/api/v1/item/register`,
      name: "",
      price: 0,
      stockQuantity: 0,
      author: "",
      isbn: "",
    };
  },

  methods: {
    save() {
      const book = {
        name: this.name,
        price: this.price,
        stockQuantity: this.stockQuantity,
        author : this.author,
        isbn: this.isbn
      }

      this.axios.post(this.saveURL, book);
    }
  }
}
</script>

<style scoped>

</style>
