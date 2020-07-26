<template>
  <div id="home">
    <v-card class="overflow-hidden">
      <v-app-bar app color="white">
        <!-- 背景渐变 -->
        <template v-slot:img="{ props }">
          <v-img v-bind="props" gradient="to top right, #fff, rgba(130,208,200,.5)"></v-img>
        </template>

        <!-- logo -->
        <v-toolbar-title style="margin-left: 20px;">
          <v-row>
            <v-col cols="3" md="3" sm="3" xs="3">
              <v-img class="img-wx" src="@/assets/img/starQ-xw.png"></v-img>
            </v-col>
            <v-col cols="2" md="2" sm="2" xs="2">
              <v-img class="img-logo" src="@/assets/img/starQ-sq.png"></v-img>
            </v-col>
          </v-row>
        </v-toolbar-title>

        <v-spacer></v-spacer>

        <!-- 搜索框 -->
        <div class="search-content" d-inline-flex align-center justify-center>
          <v-row>
            <v-col>
              <v-text-field
                id="search-input-company"
                label="搜索"
                append-icon="mdi-magnify"
                v-model="keyword"
                @click:append="fakeSearch"
                @keyup.enter="fakeSearch"
                solo
                rounded
                clearable
                autofocus
              ></v-text-field>
            </v-col>
          </v-row>
        </div>

        <!-- ...点击扩展 -->
        <v-menu bottom left>
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
        </v-menu>

        <!-- tab栏 -->
        <template v-slot:extension>
          <v-tabs align-with-title style="margin: 0 40px;">
            <router-link to="/home/index">
              <v-tab class="font-weight-bold">首页</v-tab>
            </router-link>

            <router-link to="/home/question">
              <v-tab class="font-weight-bold">小问号广场</v-tab>
            </router-link>
            <v-tab class="font-weight-bold">许愿专区</v-tab>
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

    <totop></totop>
  </div>
</template>

<script>
import totop from '@/components/totop.vue'

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
  }),
  components: {
    totop
  },
  methods: {
    fakeSearch() {
      alert(this.keyword);
    },
  },
};
</script>

<style scoped>
.search-content {
  margin-top: 30px;
  margin-right: 10px;
}
.img-logo {
  margin-top: 23px;
  margin-left: -20px;
}
.content-box {
  margin-top: 112px;
  margin-bottom: 40px;
  min-height: 600px;
  height: auto;
}

.theme--light.v-sheet {
  background-color: rgb(247, 252, 246);
}

@media (min-width: 1264px) {
  .container {
    max-width: 1264px;
  }
}
@media screen and (max-width: 694px){
  .search-content{
    display: none;
  }
}
@media screen and (max-width: 694px){
  .v-tabs.v-tabs--align-with-title.theme--light{
    margin: 0;
  }
}
</style>