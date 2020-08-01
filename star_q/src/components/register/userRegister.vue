<template>
  <div id="userRegister">
    <v-container fluid>
      <v-card class="mx-auto text-center px-8" shaped max-width="620">
        <v-card-title class="d-flex justify-center font-weight-bold">加入星问</v-card-title>
        <v-card-subtitle>Join starQ</v-card-subtitle>
        <v-divider></v-divider>
        <v-card-text>
          <ValidationObserver ref="observer" v-slot="{ validate, reset }">
            <form>
              <!-- 用户名 -->
              <ValidationProvider v-slot="{ errors }" name="用户名" rules="required|max:10">
                <v-text-field
                  v-model="username"
                  :counter="10"
                  :error-messages="errors"
                  label="用户名"
                  required
                ></v-text-field>
              </ValidationProvider>

              <!-- 邮箱 -->
              <ValidationProvider v-slot="{ errors }" name="邮箱" rules="required|email">
                <v-text-field v-model="email" :error-messages="errors" label="邮箱" required></v-text-field>
              </ValidationProvider>

              <!-- 手机号 -->
              <!-- <ValidationProvider
                v-slot="{ errors }"
                name="手机号"
                :rules="{required: true, regex: /^1[3|4|5|7|8][0-9]{9}$/}"
              >
                <v-text-field
                  v-model="phone"
                  :counter="11"
                  :error-messages="errors"
                  label="手机号"
                  required
                ></v-text-field>
              </ValidationProvider>-->

              <!-- 密码 -->
              <ValidationProvider
                v-slot="{ errors }"
                name="密码"
                rules="required|alpha_dash"
                vid="confirmation"
              >
                <v-text-field
                  v-model="password"
                  :error-messages="errors"
                  label="密码"
                  required
                  :type="show ? 'text' : 'password'"
                  :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
                  @click:append="show = !show"
                ></v-text-field>
              </ValidationProvider>

              <!-- 确认密码 -->
              <ValidationProvider
                v-slot="{ errors }"
                name="确认密码"
                rules="required|confirmed:confirmation"
              >
                <v-text-field
                  v-model="confirmPassword"
                  :error-messages="errors"
                  label="确认密码"
                  required
                  :type="show1 ? 'text' : 'password'"
                  :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
                  @click:append="show1 = !show1"
                ></v-text-field>
              </ValidationProvider>

              <!-- 验证码 -->
              <ValidationProvider v-slot="{ errors }" name="验证码" rules="required">
                <v-text-field
                  v-model="code"
                  :error-messages="errors"
                  label="验证码"
                  type="text"
                  :rules="[codeRules]"
                  required
                ></v-text-field>
                <div @click="refreshCode" title="点击刷新验证码">
                  <identify-code
                    :identifyCode="identifyCode"
                    :contentWidth="150"
                    :contentHeight="50"
                    :fontSizeMin="50"
                  />
                </div>
              </ValidationProvider>

              <!-- <v-btn @click="clear">清空</v-btn> -->
            </form>
          </ValidationObserver>
        </v-card-text>
        <v-divider></v-divider>
        <v-card-title class="d-flex justify-center">
          <v-btn outlined class="mb-1" @click="submit">注册</v-btn>
        </v-card-title>
      </v-card>
    </v-container>
  </div>
</template>

<script>
import {
  required,
  max,
  email,
  regex,
  alpha_dash,
  confirmed,
} from "vee-validate/dist/rules";
import {
  extend,
  ValidationObserver,
  ValidationProvider,
  setInteractionMode,
} from "vee-validate";

setInteractionMode("eager");

extend("required", {
  ...required,
  message: "{_field_}不能为空",
});

extend("max", {
  ...max,
  message: "{_field_}不能超过{length}个字符",
});

extend("email", {
  ...email,
  message: "请输入有效的邮箱",
});

extend("regex", {
  ...regex,
  message: "请输入有效的手机号",
});

extend("alpha_dash", {
  ...alpha_dash,
  message: "密码只能由字符、数字及下划线组成",
});

extend("confirmed", {
  ...confirmed,
  message: "确认密码与密码不一致",
});

// 随机验证码
import IdentifyCode from "@/components/comment/IdentifyCode";

export default {
  components: {
    ValidationProvider,
    ValidationObserver,
    "identify-code": IdentifyCode,
  },
  data: () => ({
    // 验证码
    code: "",
    valid: true,
    //生成验证码的字符范围
    identifyCodes: "ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz0123456789",
    //生成的验证码
    identifyCode: "",

    // 密码显示
    show: false,
    show1: false,

    // 表单数据
    username: "",
    email: "",
    // phone: "",
    password: "",
    confirmPassword: "",
  }),

  methods: {
    //生成随机数
    randomNum(min, max) {
      return Math.floor(Math.random() * (max - min) + min);
    },
    //刷新验证码
    refreshCode() {
      this.identifyCode = "";
      this.makeCode(this.identifyCodes, 4);
    },
    //生成验证码，l为生成验证码的长度
    makeCode(o, l) {
      for (let i = 0; i < l; i++) {
        //随机字符串拼接
        this.identifyCode += this.identifyCodes[
          this.randomNum(0, this.identifyCodes.length)
        ];
      }
    },
    //图片验证规则校验
    codeRules(value) {
      if (value.toLowerCase() !== this.identifyCode.toLowerCase()) {
        return "验证码输入不正确";
      } else if (value.length === 0) {
        return "验证码不能为空";
      } else {
        return true;
      }
    },
    submit() {
      this.$refs.observer.validate().then((success) => {
        if (success) {
          console.log("注册成功");
        }
      });
      // this.clear();
    },
    clear() {
      this.username = "";
      this.email = "";
      // this.phone = "";
      this.password = "";
      this.confirmPassword = "";
      this.$refs.observer.reset();
    },
  },
  mounted() {
    this.identifyCode = "";
    this.makeCode(this.identifyCodes, 4);
  },
};
</script>