<template>
  <div id="home">
    <v-card class="overflow-hidden">
      <v-app-bar app color="white">
        <!-- 背景渐变 -->
        <template v-slot:img="{ props }">
          <v-img v-bind="props" gradient="to top right, #fff, rgba(130,208,200,.5)"></v-img>
        </template>

        <!-- logo -->
        <v-toolbar-title class="ml-8 mt-1">
          <v-row>
            <v-col cols="3" md="3" sm="3" xs="3">
              <v-img class="img-wx" src="@/assets/img/starQ-xw.png"></v-img>
            </v-col>
            <v-col cols="2" md="2" sm="2" xs="2">
              <v-img class="mt-6 ml-n4" src="@/assets/img/starQ-sq.png"></v-img>
            </v-col>
          </v-row>
        </v-toolbar-title>

        <v-spacer></v-spacer>

        <!-- 搜索框 -->
        <div
          class="search-content pt-8 pr-6 d-none d-sm-flex"
          d-inline-flex
          align-center
          justify-center
        >
          <v-row>
            <v-col>
              <v-text-field
                id="search-input-company"
                label="搜索"
                append-icon="mdi-magnify"
                v-model="keyword"
                @click:append="search"
                @keyup.enter="search"
                solo
                rounded
                clearable
                autofocus
              ></v-text-field>
            </v-col>
          </v-row>
        </div>

        <!-- 登录 注册 -->
        <div class="d-flex mr-14">
          <v-btn color="yellow lighten-4 cyan--text" @click="dialogLogin = !dialogLogin">登录</v-btn>
          <router-link to="/register">
            <v-btn class="ml-2" color="yellow lighten-5 cyan--text">注册</v-btn>
          </router-link>
        </div>

        <!-- 头像 -->
        <!-- <v-menu bottom left>
          <template v-slot:activator="{ on, attrs }">
            <v-btn icon color="yellow" v-bind="attrs" v-on="on">
              <v-icon>mdi-dots-vertical</v-icon>
            </v-btn>
          </template>

          <v-list>
            <v-list-item v-for="(item, i) in items" :key="i">
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>-->

        <!-- tab栏 -->
        <template v-slot:extension>
          <v-tabs align-with-title class="mx-14">
            <router-link to="/home/index">
              <v-tab class="font-weight-bold">首页</v-tab>
            </router-link>

            <router-link to="/home/question">
              <v-tab class="font-weight-bold">小问号广场</v-tab>
            </router-link>

            <router-link to="/home/wish">
              <v-tab class="font-weight-bold">许愿专区</v-tab>
            </router-link>
          </v-tabs>
        </template>
      </v-app-bar>

      <!-- content -->
      <v-sheet id="scrolling-techniques-2">
        <v-container class="content-box">
          <router-view></router-view>
        </v-container>

        <!-- footer -->
        <v-footer color="primary lighten-1" padless>
          <v-row justify="center" no-gutters>
            <v-btn
              v-for="link in links"
              :key="link"
              color="white"
              text
              rounded
              class="my-2"
            >{{ link }}</v-btn>
            <v-col
              class="primary lighten-2 py-4 text-center white--text"
              cols="12"
            >©{{ new Date().getFullYear() }}</v-col>
          </v-row>
        </v-footer>
      </v-sheet>
    </v-card>

    <!-- 登录弹窗 -->
    <v-row justify="center">
      <v-dialog v-model="dialogLogin" persistent max-width="400">
        <v-card>
          <v-card-title class="headline d-flex justify-center">
            登 录
            <v-spacer></v-spacer>
            <v-btn icon @click="dialogLogin = false">
              <v-icon>mdi-close</v-icon>
            </v-btn>
          </v-card-title>
          <v-card-text>login dialog</v-card-text>
          <v-card-actions>
            <v-btn class="d-flex justify-center" outlined >登录</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>

    <totop></totop>
  </div>
</template>

<script>
import totop from "@/components/home/totop.vue";

export default {
  data: () => ({
    keyword: "",
    items: [
      { title: "Click Me" },
      { title: "Click Me" },
      { title: "Click Me" },
      { title: "Click Me 2" },
    ],
    links: ["首页", "关于我们", "星问团队", "联系我们"],
    dialogLogin: false,
  }),
  components: {
    totop,
  },
  methods: {
    search() {
      alert(this.keyword);
    },
  },
};
</script>

<style scoped>
.content-box {
  margin-top: 112px;
  margin-bottom: 40px;
  min-height: 600px;
}

.theme--light.v-sheet {
  background-color: rgb(247, 252, 246);
}

@media (min-width: 1264px) {
  .container {
    max-width: 1226px;
  }
}
</style>