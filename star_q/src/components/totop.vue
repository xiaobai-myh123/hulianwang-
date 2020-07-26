<template>
  <div id="totop">
    <transition name="slide-fade">
      <div class="go-to" v-show="gotop" @click="toTop">
        <svg
          width="1em"
          height="1em"
          viewBox="3 3 10 10"
          class="bi bi-arrow-up-short"
          fill="currentColor"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            fill-rule="evenodd"
            d="M8 5.5a.5.5 0 0 1 .5.5v5a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5z"
          />
          <path
            fill-rule="evenodd"
            d="M7.646 4.646a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8 5.707 5.354 8.354a.5.5 0 1 1-.708-.708l3-3z"
          />
        </svg>
      </div>
    </transition>
  </div>
</template>

<script>
export default {
  name: "home",
  data() {
    return {
      gotop: false
    };
  },
  mounted() {
    // 此处true需要加上，不加滚动事件可能绑定不成功
    window.addEventListener("scroll", this.scrollToTop, true);
  },
  destroyed() {
    window.removeEventListener("scroll", this.scrollToTop);
  },
  methods: {
    scrollToTop() {
      let scrolltop =
        document.documentElement.scrollTop ||
        document.body.scrollTop ||
        window.pageYOffset;
      scrolltop > 100 ? (this.gotop = true) : (this.gotop = false);
    },
    toTop() {
      let top =
        window.pageYOffset ||
        document.documentElement.scrollTop ||
        document.body.scrollTop;
      // 实现滚动效果
      const timeTop = setInterval(() => {
        document.body.scrollTop = document.documentElement.scrollTop = top -= 30;
        if (top <= 0) {
          clearInterval(timeTop);
        }
      }, 10);
    }
  }
};
</script>

<style scoped>
.go-to {
  position: fixed;
  right: 50px;
  bottom: 128px;
  display: inline-flex;
  justify-content: center;
  align-items: center;
  z-index: 9999;
  width: 45px;
  height: 45px;
  background-color: rgba(113, 134, 157, 0.2);
  color: #006eff;
  border-radius: 50%;
  transition: 0.3s ease-out;
  cursor: pointer;
}
.go-to:hover,
.go-to:focus:hover {
  color: #fff;
  background-color: rgb(71,172,255);
}
.slide-fade-enter-active {
  transition: all 0.5s ease;
}
.slide-fade-leave-active {
  transition: all 0.5s cubic-bezier(1, 0.5, 0.8, 1);
}
.slide-fade-enter,
.slide-fade-leave-to {
  transform: translateY(30px);
  opacity: 0;
}
</style>

