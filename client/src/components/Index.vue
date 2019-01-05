<template>
  <div>
    <router-link to="/add">新增</router-link>
    <div class="center" style="width: 702px;">
        <el-table :data = 'userData' height="250" stripe border style="width: 100%">
            <el-table-column prop="id" label="ID" width="80"></el-table-column>
            <el-table-column prop="userName" label="名字" width="120"></el-table-column>
            <el-table-column prop="userAge" label="年龄" width="80"></el-table-column>
            <el-table-column prop="userAddress" label="地址" width="300"></el-table-column>
            <el-table-column label="操作" width="120">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
                    
                    <el-button @click="deleted(scope.row.id)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            userData: ''
        }
    },
    methods: {
        handleClick(row) {
            this.$log.debug(row)
        },
        getData() {
            axios
                .get('http://localhost:8001/selectAll')
                .then(response => {
                    this.userData = response.data
                    this.$log.debug(response)
                }).catch(error => {
                    this.$log.debug(error)  
                })
        },
        deleted(id) {
            var deleteConfirm = confirm('是否刪除')
            if(deleteConfirm){
                axios({
                    method: 'post',
                    url: 'http://localhost:8001/deleteUser',
                    data: "&id=" + id
                }).then(response => {
                    this.$log.debug(response)
                    this.getData();
                }).catch(error => {
                    this.$log.debug(error)  
                })
            }
        } 
    },
    created() {
        this.getData()
    }
}
</script>

<style scoped>
    .center {
        margin-left: auto;
        margin-right: auto;
    }
</style>
