<template>
  <div>
    <p>회원 목록</p>
    <section style="border-top: 1px solid black;">
      <div v-for="member in members" :key="member" style="border-bottom: 1px solid black;">
        <p>아이디: {{member.id}}</p>
        <p>이름: {{member.name}}</p>
        <section v-if="member.address">
          <p>도시 : {{member.address.city}}</p>
          <p>거리: {{member.address.street}}</p>
          <p>우편번호: {{member.address.zipcode}}</p>
        </section>
        </div>
    </section>
  </div>
</template>

<script>
export default {
  name: "MemberList",
  inject: ['axios'],

  data() {
    return {
      findURL: "/rest/api/v1/member",
      members: [],
    }
  },

  created() {
    this.axios.get(`${this.findURL}/members`).then(response => {
      if (!(response.status <= 200 || response >= 400)) {
        throw new Error("response error");
      }
      this.members = response.data;
    }).catch(error => {
      console.log({error})
    })
  },
}
</script>

<style scoped>

</style>
