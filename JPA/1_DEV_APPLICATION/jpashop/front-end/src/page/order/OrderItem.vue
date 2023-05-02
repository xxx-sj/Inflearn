<template>
  <div>
    <form @submit.prevent="save">
      <select v-model="selectedMember">
        <option v-for="member in members" :key="member" :value="member">{{member.name}}</option>
      </select>
      <select v-model="selectedItem">
        <option v-for="item in items" :key="item" :value="item">{{item.name}}</option>
      </select>
      <input type="number" v-model="count"/>
      <button type="submit">submit</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "OrderItem",
  inject: ['axios'],

  data() {
    return {
      requestURL: "/rest/api/v1",
      members: [],
      items: [],
      selectedMember: null,
      selectedItem: null,
      count: 0,
    };
  },

  created() {
    this.init();
  },

  methods: {
    init() {
      this.axios.all([this.findMembers(), this.findItems()]).then(this.axios.spread((members, items) => {
        this.members = members.data;
        this.items = items.data;
      }))
    },
    findMembers() {
      return this.axios.get(`${this.requestURL}/member/members`);
    },

    findItems() {
      return this.axios.get(`${this.requestURL}/item/items`);
    },

    save() {
      this.axios.post(`${this.requestURL}/order/orders`, {}, {
        params: {
          memberId: this.selectedMember.id,
          itemId: this.selectedItem.id,
          count: this.count,
        }
      })
    }
  }

}
</script>

<style scoped>

</style>