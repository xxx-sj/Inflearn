<template>
  <div>
    <form @submit.prevent="edit" v-if="item">
      <p>상품명</p>
      <input type="text" v-model="item.name"/>
      <p>가격</p>
      <input type="number" v-model="item.price"/>
      <p>수량</p>
      <input type="number" v-model="item.stockQuantity"/>
      <p>저자</p>
      <input type="text" v-model="item.author"/>
      <p>ISBN</p>
      <input  type="text" v-model="item.isbn"/>
      <section>
        <button type="submit">수정</button>
      </section>
    </form>
  </div>
</template>

<script>
export default {
  name: "ItemDetail",
  inject: ['axios'],
  data() {
    return {
      detailURL: "/rest/api/v1/item/items",
      item: null,
    }
  },

  created() {
    this.axios.get(`${this.detailURL}/${this.$route.params.id}/edit`)
        .then(response => {
          this.item = response.data;
        })
  },

  methods: {
    edit() {
      this.axios.put(`${this.detailURL}/${this.$route.params.id}/edit`, this.item)
    }
  }
}
</script>

<style scoped>

</style>
