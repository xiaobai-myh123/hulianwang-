<template>
  <div class="content" id="start">
    <div class="title slide-bar">
      <img src="@/assets/img/starQ-xw.png" alt="星问" />
    </div>
    <div class="subtitle slide-bar">
      <img src="@/assets/img/starQ-sq.png" alt="starQ" />
    </div>
    <div class="begin slide-bar">
      <div class="footer">
        <div class="jump-font" v-html="jumpFont"></div>
        <div class="btn-box">
          <router-link to="/home/index">
            <button class="btn btn-hue btn-bubbles">开 启</button>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { stopExecutionOnTimeout } from "@/assets/js/stopExecutionOnTimeout.js";

export default {
  data() {
    return {
      jumpFont: "",
    };
  },
  created() {
    this.useStopExe();
  },
  methods: {
    useStopExe() {
      var jump = "让每个?都能起飞";
      var letters = jump.split("");
      letters.forEach((letter, i) => {
        var span = document.createElement("span");
        span.innerText = letter;
        span.style.animationDelay = i / 30 + "s";
        if (letter == "?") {
          span.style.color = "#ffb7b7";
        }
        this.jumpFont += span.outerHTML;
      });
    },
  },
};
</script>

<style scoped>
@import "../assets/css/start.css";
</style>