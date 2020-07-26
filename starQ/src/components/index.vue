<template>
  <v-row justify="center">
    <v-col class="article-content">
      <v-expansion-panels>
        <v-expansion-panel v-for="item in textList" :key="item.id">
          <v-expansion-panel-header>
            <h3>{{ item.title }}</h3>
          </v-expansion-panel-header>
          <v-expansion-panel-content>
            <div>
              <v-avatar size="36px">
                <img class="head-portrait" src="@/assets/img/starQ-s.png" />
              </v-avatar>
              <span class="grey--text">{{ item.artist }}</span>
            </div>
            <div class="text-content">{{ item.textFront }}...</div>
            <router-link to="/home/text?id=">阅读全文</router-link>
          </v-expansion-panel-content>
        </v-expansion-panel>
      </v-expansion-panels>
    </v-col>
    <v-col class="col-3 card-content">
      <v-card class="mx-auto">
        <v-card-text class="text-center">
          <img class="cart-logo" src="@/assets/img/starQ-s.png" alt="startQ" />
          <h3>-- 让每个小问号都能起飞</h3>
          <v-btn class="text-content" text color="indigo">
            去提问
            <v-icon>mdi-chevron-right</v-icon>
          </v-btn>
        </v-card-text>
      </v-card>
      <v-card class="mx-auto">
        <v-card-text class="text-center">
          <img class="cart-logo" src="@/assets/img/starQ-i.png" alt="startQ" />
          <h3>加入解答师</h3>
          <h4 class="cart-interval">来测测是否能通过考验吧！</h4>
          <v-btn class="text-content" text color="indigo">
            去测试
            <v-icon>mdi-chevron-right</v-icon>
          </v-btn>
        </v-card-text>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
export default {
  data: () => ({
    textList: [
      {
        id: 0,
        title: "《写给孩子的新型冠状病毒科普绘本》",
        artist: "一个爱读书的人",
        textFront:
          "绘本针对3-6岁孩子的心理认知特点，将病毒科普和自我防护知识融入日常场景，以简明精准的语言和暖心故事的形式让孩子们更好地理解疫情，建立相应的自我保护观和道德法制观，为抗击疫情，为人类健康的未来贡献自己的力量",
      },
      {
        id: 1,
        title: "为什么人会打呵欠？",
        artist: "科普小星问",
        textFront:
          "当我们感到疲累时，体内已产生了许多的二氧化碳。当二氧化碳过多时，必须再增加氧气来平衡体内所需。因为这些残留的二氧化碳，会影响我们身体的机能活动，这时身体便会发出保护性的反内所需。因为这些残留的二氧化碳，会",
      },
      {
        id: 2,
        title: "地球为什么是圆的?",
        artist: "科普小星问",
        textFront:
          "地球是很早以前在太阳系中的岩石相互碰撞、形成各个行星时诞生的。地球从形成之初直至现在，主要是由液态岩石构成的，在引力极小的太空，液态物质将自动形成球形。另外，由于地球自转的离心力，加上自身的引力，收缩成球形才",
      },
      {
        id: 3,
        title: "为什么人的大拇指不可以有一或三节？",
        artist: "科普小星问",
        textFront:
          "一般人有五只手指，而手指的长度各有不同。除了大拇指外，其它手指也有三节，而唯独大拇指只有两节?原来，它的节数正好配合其它四指。要是三节的话，大拇指会显得没有力，以致不能提起较重的物件;要是只得—节，它便不能自",
      },
      {
        id: 4,
        title: "为什么自己搔自己时不感到很痒?",
        artist: "科普小星问",
        textFront:
          "当别人搔自己时，我们会倍感痕痒，而且不断大笑;可是，当自己搔自己的时候，我们不单不会大笑，而且更不感痕痒。基于我们的思想上已有了准备，大脑会发出一种不会有危险的讯息，神经亦随之放松，所以便不会大笑起来和感到",
      },
      {
        id: 5,
        title: "为什么人老了头发便会变白?",
        artist: "科普小星问",
        textFront:
          "我们的头发中有一种叫「黑色素」的物质，黑色素愈多头发的颜色便愈黑。而黑色素少的话，头发便会发黄或变白。人类到了老年时，身体的各种机能会逐渐衰退，色素的形成亦会愈来愈少，所以头发也会渐渐变白啊!",
      },
      {
        id: 6,
        title: "为什么萤火虫会发光?",
        artist: "科普小星问",
        textFront:
          "萤火虫会发光因为在它们的腹部末端有发光器，发光器内充满许多含磷的发光质及发光酵素，使萤火虫能发出一闪一闪的光。萤火虫发光的目的，除了要照明之外，还有求偶、警戒、诱捕等用途。这也是它们的一种沟通的工具，不同种",
      },
      {
        id: 7,
        title: "为什么驼鸟不会飞?",
        artist: "科普小星问",
        textFront:
          "身型庞大的驼鸟类的一种，但它们却不会飞上天啊!这不是因为它们的翅膀不管用，而是它们的羽毛都太柔软，翅膀又太小，根本不适合飞行。另外，驼鸟的肌肉不发达，胸骨又平平的，对飞行都没有帮助。驼鸟生活在非洲，由于长期居",
      },
      {
        id: 8,
        title: "为什么肚子饿了会咕咕叫?",
        artist: "科普小星问",
        textFront:
          "肚子饿了便会咕噜咕噜地叫，这是因为之前吃进的食物快消化完，胃里虽然空空的，但胃中的胃液仍会继续分泌。这时候胃的收缩便会逐渐扩大，内里的液体和气体便会翻搅起来，造成咕噜咕噜的声音，是正常的生理动作",
      },
    ],
  }),
};
</script>

<style scoped>
.text-content {
  margin-top: 10px;
  font-weight: 500;
}
.article-content {
  width: 100%;
}
.head-portrait {
  margin-right: 20px;
}
.mx-auto {
  margin-bottom: 10px;
}
.cart-logo {
  width: 100px;
  height: 100px;
  margin: -20px 0;
}
.cart-interval {
  margin-top: 6px;
}
@media screen and (max-width: 1268px) {
  .card-content {
    display: none;
  }
}
</style>