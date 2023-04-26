<template>
  <div>
    <form>
      <section class="name-section section-container">
        <label>이름</label>
        <input type="text" v-model="name"/>
      </section>
      <section class="city-section section-container">
        <label>도시</label>
        <input type="text" v-model="city"/>
      </section>
      <section class="street-section section-container">
        <label>거리</label>
        <input type="text" v-model="street"/>
      </section>
      <section class="zipcode-section section-container">
        <label>우편번호</label>
        <input type="text" v-model="zipcode"/>
      </section>
      <button type="submit" @click.prevent="save">등록</button>
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
      name: null,
      city: "",
      street: "",
      zipcode: "",
    }
  },

  methods: {
    async save() {

      const member = {
        name: this.name,
        city: this.city,
        street: this.street,
        zipcode: this.zipcode,
      };

      await this.axios.post(`${this.registerURL}/register`, member)
          .then(response => {
            console.log({response})
          })
          .catch(error => {
            console.log({error})
          })

      await this.axios.get(`${this.registerURL}/member`).then(response => {
        console.log({response});
      })
    }
  }
}
</script>

<style scoped>
  .section-container {
    padding: 10px;
    display: flex;
    justify-content: center;
  }
  .section-container label {
    width: 100px;
  }
</style>
