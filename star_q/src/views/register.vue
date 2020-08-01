<template>
  <div id="register">
    <h2 class="register-title text-center">请选择通道进行注册</h2>
    <div class="l-btn-content">
      <router-link to="/register/userRegister?state=0">
        <v-btn
          class="user-btn userq-btn text-body-1"
          rounded
          outlined
          width="180"
          height="90"
          color="orange accent-2"
        >“小问号”通道</v-btn>
      </router-link>
      <router-link to="/register/userTest">
        <v-btn
          class="user-btn users-btn text-body-1"
          rounded
          outlined
          width="180"
          height="90"
          color="teal lighten-3"
        >解答师通道</v-btn>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
#register {
  position: fixed;
  width: 100%;
  height: 100%;
  background: url(../assets/img/starQ-bg.png) no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
.register-title {
  margin-top: 8%;
}
.l-btn-content {
  position: fixed;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  margin-top: 10%;
}
.users-btn {
  margin-left: 50px;
}
@media screen and (max-width: 500px) {
  .l-btn-content {
    display: block;
    margin-top: 20%;
  }
  .users-btn {
    margin-top: 30px;
    margin-left: 0;
  }
}
</style>