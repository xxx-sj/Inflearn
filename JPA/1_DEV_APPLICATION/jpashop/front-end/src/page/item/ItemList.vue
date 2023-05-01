<template>
  <div>
    상품 목록
    <div v-for="item in items" :key="item" style="border-bottom: 1px solid black">
      <p>index: {{item.id}}</p>
      <p>이름: {{item.name}}</p>
      <p>가격: {{item.price}}</p>
      <p>수량: {{item.stockQuantity}}</p>
      <button type="" @click="edit(item.id)">수정</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "ItemList",
  inject: ['axios'],
  data() {
    return {
      items: [],
    };
  },

  created() {
    this.axios.get("/rest/api/v1/item/items").then(response => {
      //TODO something validation
      this.items = response.data;
    })
  },

  methods: {
    edit(id) {
      console.log(this.$route)
      console.log(this.$router)
      this.$router.push({path: `${this.$route.fullPath}/${id}/edit`});
    },
  }
}
</script>

<style scoped>

</style>
