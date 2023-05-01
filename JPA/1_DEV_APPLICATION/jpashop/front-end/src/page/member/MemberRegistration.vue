<template>
  <div style="display: flex; justify-content: center">
    <form @submit.prevent="save">
      <section>
        <p>이름</p>
        <input type="text" v-model="name"/>
      </section>
      <section>
        <p>도시</p>
        <input type="text" v-model="city"/>
      </section>
      <section>
        <p>거리</p>
        <input type="text" v-model="street"/>
      </section>
      <section>
        <p>우편번호</p>
        <input type="text" v-model="zipcode"/>
      </section>
      <section>
        <button type="submit">제출</button>
      </section>
    </form>
  </div>
</template>

<script>
export default {
  name: "MemberRegistration",
  inject: ['axios'],

  data() {
    return {
      registerURL: '/rest/api/v1/member',
      name: "",
      city: "",
      street: "",
      zipcode: "",
    };
  },

  methods: {
    save() {
      const member = {
        name: this.name,
        city: this.city,
        street: this.street,
        zipcode: this.zipcode,
      };

      this.axios.post(`${this.registerURL}/register`, member);
    }
  }
}
</script>

<style scoped>
  section input {
    margin-left: 10px;
  }
</style>
