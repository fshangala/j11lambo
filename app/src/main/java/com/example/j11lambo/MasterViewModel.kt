package com.example.j11lambo

import androidx.lifecycle.MutableLiveData

class MasterViewModel:Y11ViewModel() {
    var browserLoading = MutableLiveData<Boolean>(false)
}