<template>
	<view>
		<view class="cu-bar bg-white search" :style="[{top:CustomBar + 'px'}]">
				<picker v-if="queryList.length>1" mode="selector" :range="queryList" range-key="queryName"
					:value="queryIndex" @change="queryChange" style="padding-left: 20upx;">
					<view>
						<image style="width: 20upx;height: 33upx;" src="../../static/center/to.png"></image>
					</view>
				</picker>
				<view class="search-form round">
					<text class="cuIcon-search"></text>
					<input v-model="searchForm.goodsOrderUuidNumber" style="width: 200rpx;" type="text" placeholder="展柜订单号"></input>
				</view>
				<view class="action">
					<button @tap="search"
						:style="{width:'auto',borderRadius:'40rpx',height:'80rpx',fontSize:'28rpx',color:'rgba(239, 239, 239, 1)',backgroundColor:btnColor[0],borderColor:btnColor[0]}"
						class="cu-btn shadow-blur round">搜索</button>
				</view>
		</view>
		
				<scroll-view  scroll-x class="bg-white nav">
					<view class='flex text-center'>
						<view class="cu-item flex-sub text-df " @click="navselect(0)"
						 :class="[currentIndex == 0 ? 'text-red cur' : '']">
							全部
						</view>
						<view class="cu-item flex-sub text-df " @click="navselect(nav.codeIndex)" v-for="(nav,index) in navlist" :key="index"
						 :class="[currentIndex == nav.codeIndex ? 'text-red cur' : '']">
							{{nav.indexName}}
						</view>
					</view>
				</scroll-view>
		
		<mescroll-uni :top="200" @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
			<view v-for="(item,index) in list" :key="index">
				<view class="bg-white margin-sm padding-sm solids-bottom radius text-content">
					<view class="flex justify-between">
						<view class="text-bold" style="flex-shrink: 0;">
							<text class="text-orange">{{ item.goodsOrderTypes == 1?item.goodsOrderValue:'' }}</text>
							<text class="text-red">{{ item.goodsOrderTypes == 2?item.goodsOrderValue:'' }}</text>
							<text class="text-yellow">{{ item.goodsOrderTypes == 3?item.goodsOrderValue:'' }}</text>
							<text class="text-grey">{{ item.goodsOrderTypes == 4?item.goodsOrderValue:'' }}</text>
							<text class="text-orange">{{ item.goodsOrderTypes == 5?item.goodsOrderValue:'' }}</text>
							<text class="text-red">{{ item.goodsOrderTypes == 6?item.goodsOrderValue:'' }}</text>
							<text class="text-blue">{{ item.goodsOrderTypes == 7?item.goodsOrderValue:'' }}</text>
							<text class="text-green">{{ item.goodsOrderTypes == 8?item.goodsOrderValue:'' }}</text>

						</view>
						<view><text class="icon-goods padding-right-sm"></text><text class="text-bold solids-bottom">{{ item.goodsOrderUuidNumber }}</text></view>
					</view>
					<view class="bg-white margin-xs padding-xs  radius text-content">
						<view class="flex padding-top-sm solids-top">
							<image :src="item.goodsPhoto" style="flex-shrink: 0;" mode="aspectFill" class=" cover radius solids"></image>
							<view class="text-content padding-left" style="flex-grow: 1;">
								<view>{{ item.goodsName }}</view>
								<view>{{ item.goodsValue }}</view>
								<view >{{ item.buyNumber }} x ￥{{ item.goodsNewMoney }}</view>
							</view>
						</view>
						<view class="flex justify-end">合计{{ item.goodsOrderTruePrice }}元</view>
					</view>
					<view class="flex justify-end"></view>
					<view class="flex justify-end" style="font-size: 24upx;">
						<view v-if="item.goodsOrderTypes == 1">
							<view @tap="onCancelTap(item)" class="round cu-btn lines-grey mid  margin-right-sm">退款</view>
						</view>
						<view v-if="item.goodsOrderTypes == 1">
							<view @tap="onChatTapB(item.id)" class="round cu-btn lines-grey mid  margin-right-sm">发送需求</view>
						</view>
						<view v-if="item.goodsOrderTypes >= 4 && item.goodsShejituPhoto != null ">
							<view @tap="onChatTapA(item.goodsShejituPhoto)" class="round cu-btn lines-grey mid  margin-right-sm">查看设计图</view>
						</view>
						<view v-if="item.goodsOrderTypes == 4">
							<view @tap="onChatTapC(item.id,5)" class="round cu-btn lines-grey mid  margin-right-sm">通过</view>
							<view @tap="onChatTapC(item.id,6)" class="round cu-btn lines-grey mid  margin-right-sm">拒绝</view>
						</view>
						<view v-if="item.goodsOrderTypes == 7">
							<view @tap="onshouhuoTap(item.id,8)" class="round cu-btn lines-grey mid  margin-right-sm">收货</view>
						</view>
					</view>
				</view>
			</view>
			
			<uni-popup class="popup-content" ref="popupA" type="center">
				<form class="popup-form">
					<view class="uni-flex uni-column" style="background-color: #FFFFFF;border-radius: 10rpx;width: 650rpx;">
						<view class="flex-item flex-item-V">
							<image style="margin: 20rpx 25rpx 20rpx 25rpx; width: 600rpx"
								:src='shejituPhoto' mode="aspectFill"></image>
						</view>
						<view class="flex-item flex-item-V" style="text-align: right;background: #FFFFFF;">
							<button @tap="onCloseWinTapA" style="margin: 0 40% 10rpx 50rpx;" class="cu-btn bg-cyan">关闭</button>
						</view>
					</view>
				</form>
			</uni-popup>
			
			<uni-popup class="popup-content" ref="popupB" type="center">
				<form class="popup-form">
					<view class="uni-flex uni-column" style="background-color: #FFFFFF;border-radius: 10rpx;width: 650rpx;">
						<view class="flex-item flex-item-V" style="text-align: center;font-size: 40upx;font-weight: bold;margin: 20upx;">需求详情</view>
						<view class="flex-item flex-item-V">
							<view
							        :style='{"boxShadow":"0 0 0px rgba(0,0,0,.3)","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(218, 220, 219, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"108rpx"}'
							        class="cu-form-group" @tap="goodsXuqiuPhotoTap">
							    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"rgba(0, 102, 51, 1)","textAlign":"left"}'
							          class="title">需求图片</view>
							    <view class="right-input" style="padding:0;textAlign:left">
							        <image :style='{"width":"80rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","borderRadius":"100%","textAlign":"left","height":"80rpx"}'
							                class="avator" :src="goodsXuqiuPhoto" mode="aspectFill">
							        </image>
							    </view>
							</view>
							<view
								:style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"210rpx"}'
								class="cu-form-group">
								<view :style='{"width":"160rpx","fontSize":"28rpx","color":"rgba(0, 102, 51, 1)","textAlign":"left"}'
									class="title">展柜需求</view>
									<textarea :style='{"backgroundColor":"rgba(255, 255, 255, 0)","textAlign":"left","borderWidth":"0 0 0","fontSize":"28rpx","borderStyle":"solid","height":"200rpx"}'
									  v-model="goodsXuqiuText" placeholder="展柜需求详情"/>
							</view>
						</view>
						<view class="flex-item flex-item-V" style="text-align: right;background: #FFFFFF;">
							<button @tap="onCloseWinTapB" style="margin: 0 0 10rpx 50rpx;" class="cu-btn bg-cyan">取消</button>
							<button @tap="onFinishTapB" style="float: right;margin: 0 50rpx 10rpx 0;" class="cu-btn bg-red">确认</button>
						</view>
					</view>
				</form>
			</uni-popup>
		
			
		</mescroll-uni>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				navlist: [
				],
				btnColor: ['#409eff', '#67c23a', '#909399', '#e6a23c', '#f56c6c', '#356c6c', '#351c6c', '#f093a9',
					'#a7c23a', '#104eff', '#10441f', '#a21233', '#503319'
				],
				CustomBar: '0',
				currentIndex: 0,
				pages: 1,
				queryList: [{
						queryName: "展柜设计名称",
					}
				],
				searchForm: {},
				list: [],
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					page: {
						// num: 0, // 当前页码,默认0,回调之前会加1,即callback(page)会从1开始
						// size: 5 // 每页数据的数量
					},
					noMoreSize: 3, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				goodsLiuyanText: '',
				user: '',
				shejituPhoto:'',
				goodsXuqiuPhoto:'',
				goodsXuqiuText:'',
				orderId:'',
			}
		},
		async onShow() {
			this.btnColor = this.btnColor.sort(() => {
				return (0.5 - Math.random());
			});
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table)
			this.user = res.data
			this.hasNext = true
			
			let params = {
				page: 1,
				limit: 100,
				dicCode: 'goods_order_types',
			}
			let res1 = await this.$api.page(`dictionary`, params);
			
			this.navlist = res1.data.list
			
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		methods: {
			onChatTapC(id,types){
				let detail = {
					id: id,
					goodsOrderTypes: types
				}
				this.$api.update('goodsOrder', detail);
				this.$utils.msg('审核成功');
				if (this.mescroll) this.mescroll.resetUpScroll()
				this.$refs.popupB.close();
			},
			onCloseWinTapA() {
				this.$refs.popupA.close()
			},
			onChatTapA (file) {
				this.shejituPhoto = file
				this.$refs.popupA.open()
			},
			onCloseWinTapB() {
				this.$refs.popupB.close()
			},
			onChatTapB (id) {
				this.orderId = id
				this.goodsXuqiuPhoto = null
				this.goodsXuqiuText = null
				this.$refs.popupB.open()
			},
			async onFinishTapB() {
				if (!this.goodsXuqiuPhoto) {
					this.$utils.msg('展柜需求图片不能为空');
					return
				}
				if (!this.goodsXuqiuText) {
					this.$utils.msg('展柜需求详情不能为空');
					return
				}
				let detail = {
					id: this.orderId,
					goodsXuqiuText: this.goodsXuqiuText,
					goodsXuqiuPhoto: this.goodsXuqiuPhoto,
					goodsOrderTypes: 3
				}
				await this.$api.update('goodsOrder', detail);
				this.$utils.msg('需求发送成功');
				if (this.mescroll) this.mescroll.resetUpScroll()
				this.$refs.popupB.close();
			},
			goodsXuqiuPhotoTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.goodsXuqiuPhoto = _this.$base.url + 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(() => {
						// _this.styleChange()
					})
				});
			},
			navselect(nav) {
				this.currentIndex = nav
				this.goodsOrderTypes = nav
				this.hasNext = true
				// 重新加载数据
				if (this.mescroll) this.mescroll.resetUpScroll()
			},
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size,
				}
				if (this.goodsOrderTypes) {
					params['goodsOrderTypes'] = this.goodsOrderTypes
				}
				let res = await this.$api.page('goodsOrder', params);
				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			async onCancelTap(order) {
				let _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认退款',
					success: async function(res) {
						if(res.confirm){
							var value = [
								{
									key:'id',
									val:order.id,
								}
							]
							var returnVal = await _this.$api.requestCondition("goodsOrder", "refund",value);
							_this.$utils.msgBack('退款成功');
							if (_this.mescroll) _this.mescroll.resetUpScroll()
						}
					}
				});
			},
			async onshouhuoTap(id,types){
				let _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认要收货吗？',
					success: async function(res) {
						if(res.confirm){
							let order = {
								id: id,
								goodsOrderTypes: types
							}
							var returnVal = await _this.$api.update("goodsOrder",order);
							_this.$utils.msgBack('收货成功');
							if (_this.mescroll) _this.mescroll.resetUpScroll()
						}
					}
				});
			},
			async search() {
				let params = {
					page: this.mescroll.num,
					limit: this.mescroll.size
				}
				if (this.searchForm.goodsOrderUuidNumber) {
					params['goodsOrderUuidNumber'] = this.searchForm.goodsOrderUuidNumber
				}
				if (this.goodsOrderTypes) {
					params['goodsOrderTypes'] = this.goodsOrderTypes
				}
				
				let res = await this.$api.page('goodsOrder', params);
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
			}
			
		}
	}
</script>

<style>
	.cover {
		width: 150upx;
		height: 150upx;
	}
</style>
