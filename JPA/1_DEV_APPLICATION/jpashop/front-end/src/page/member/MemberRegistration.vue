<template>
  <div>
    <form @submit.prevent="save">
      <label>이름</label>
      <input type="text" />
      <label>도시</label>
      <label>거리</label>
      <label>우편번호</label>
      <button type="submit">제출</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "MemberRegistration",
  inject: ['axios'],

  methods: {
    save() {
      this.axios.post('/rest/api/v1/member/register', {name: "aa"});
    }
  }
}
</script>

<style scoped>

</style>
