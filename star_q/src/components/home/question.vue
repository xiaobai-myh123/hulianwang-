<template>
  <div id="question">
    <v-row justify="center">
      <v-col class="col-md-9 col-sm-12">
        <v-card class="mx-auto card-h">
          <v-img src="@/assets/img/starQ-bg1.png">
            <v-card-text align="center">
              <h3 class="card-title-h">寄出我的“小问号”</h3>
              <v-row class="card-body rounded-xl" align="center">
                <v-col class="col-10 mx-0 px-0">
                  <v-text-field
                    v-model="iQuestion"
                    @keyup.enter="sendQuestion"
                    label="输入“小问号”"
                    required
                  ></v-text-field>
                </v-col>
                <v-col class="col-2 pa-0">
                  <v-btn text @click="sendQuestion">发送</v-btn>
                </v-col>
              </v-row>
            </v-card-text>
          </v-img>
        </v-card>
      </v-col>
    </v-row>

    <v-row>
      <v-col class="col-md-6 col-sm-12" v-for="item in questionList" :key="item.id">
        <v-hover v-slot:default="{ hover }">
          <div class="d-flex flex-column-reverse">
            <v-card class="mx-auto" :elevation="hover ? 12 : 3" :class="{ 'on-hover': hover }">
              <v-img src="@/assets/img/starQ-bg2.png">
                <v-card-text align="center">
                  <v-row>
                    <v-col class="col-2 img-user-content">
                      <v-img class="img-user" src="@/assets/img/hmbb.jpg"></v-img>
                    </v-col>
                  </v-row>
                  <div class="card-content">
                    <h3 class="card-title">
                      <span class="brown--text">{{ item.username }}</span>的“小问号”：
                    </h3>
                    <h2 class="cart-interval q-font">{{ item.question }}</h2>
                  </div>
                </v-card-text>

                <!-- 悬停按钮 -->
                <v-expand-transition>
                  <div
                    v-if="hover"
                    class="d-flex transition-fast-in-fast-out blue lighten-4 v-card--reveal"
                    style="height: 100%;"
                  >
                    <v-btn rounded light>
                      解答
                      <v-icon size="18">mdi-pencil</v-icon>
                    </v-btn>
                  </div>
                </v-expand-transition>
              </v-img>
            </v-card>
          </div>
        </v-hover>
      </v-col>
    </v-row>

    <!-- 提示 -->
    <v-snackbar v-model="snackbar" :timeout="timeout" top color="#fff" light>
      {{ sText }}
      <template v-slot:action="{ attrs }">
        <v-btn color="blue" text v-bind="attrs" @click="snackbar = false">关闭</v-btn>
      </template>
    </v-snackbar>
  </div>
</template>

<script>
export default {
  data() {
    return {
      iQuestion: "",
      questionList: [
        {
          id: 0,
          // userImg: "",
          username: "小朋友A",
          question: "肚子饿了为什么会叫？",
        },
        {
          id: 1,
          username: "小朋友B",
          question: "为什么地球是圆的？",
        },
        {
          id: 2,
          username: "小朋友C",
          question: "为什么地球是圆的？",
        },
      ],
      snackbar: false,
      sText: "",
      timeout: 3000,
    };
  },
  methods: {
    sendQuestion() {
      var qList = {};
      if (this.iQuestion.length > 0) {
        qList.id = this.questionList.length;
        qList.username = "hahaha";
        qList.question = this.iQuestion;
        this.questionList.push(qList);

        // 数组反转，让添加的数据始终在第一位
        this.questionList.reverse();

        // 清空输入框
        this.iQuestion = "";

        // 弹出提示
        this.sText = "“小问号”寄送成功，静静等待回信吧！";
        this.snackbar = true;
      } else {
        // 输入为空
        this.sText = "“小问号”不能为空哦~";
        this.snackbar = true;
      }
    },
  },
};
</script>

<style scoped>
.card-h {
  border: 1px solid rgb(170, 170, 170);
}
.card-title-h {
  margin-top: 6.5%;
  font-size: 1.6em;
}
.card-body {
  width: 70%;
  margin-top: 16%;
  padding: 2% 5% 0;
  background-color: #ebeffc;
  border: 3px dashed rgb(224, 224, 224);
}
.img-user-content {
  margin-top: 1%;
  margin-left: 5.8%;
  padding: 1.2%;
}
.img-user {
  border: 3px double rgb(122, 122, 122);
}
.card-title {
  margin-top: 5%;
  font-size: 1.3em;
}
.card-content {
  margin-top: -16%;
}
.cart-interval {
  margin-top: 19%;
}
.q-font {
  color: #fff;
  font-size: 1.8em;
  letter-spacing: 5px;
  text-shadow: 0 1px #bbb, 0 2px #bbb, 0 3px #bbb, 0 4px #bbb, 0 5px #bbb,
    0 6px transparent, 0 7px transparent, 0 8px transparent, 0 9px transparent,
    0 10px 10px rgba(0, 0, 0, 0.4);
  transform: translateY(20px);
}
.v-card--reveal {
  align-items: center;
  bottom: 0;
  justify-content: center;
  opacity: 0.5;
  position: absolute;
  width: 100%;
}
</style>