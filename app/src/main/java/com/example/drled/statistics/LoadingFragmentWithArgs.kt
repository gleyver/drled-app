package com.example.drled.statistics

import android.os.Bundle
import androidx.fragment.app.Fragment

interface LoadingFragmentWithArgs {

    fun loadFragmentWithArgs(fragment: Fragment, bundle: Bundle)
}