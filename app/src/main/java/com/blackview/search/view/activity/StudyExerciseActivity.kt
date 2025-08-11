package com.blackview.search.view.activity

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.blackview.base.common.IPlayCallBack
import com.blackview.base.common.adapter.BaseFragmentPagerAdapter
import com.blackview.base.common.ui.BaseActivity
import com.blackview.base.kt.ktClick
import com.blackview.base.kt.ktClickNoDelay
import com.blackview.search.R
import com.blackview.base.utils.AudioPlayerManger
import com.blackview.search.bean.SubjectBean
import com.blackview.search.bean.SubjectType
import com.blackview.search.common.Const
import com.blackview.search.core.VoiceAgainInterface
import com.blackview.search.databinding.ActivityStudyExerciseBinding
import com.blackview.search.view.fragment.ExerciseActionFiveFragment
import com.blackview.search.view.fragment.ExerciseActionFourFragment
import com.blackview.search.view.fragment.ExerciseActionOneFragment
import com.blackview.search.view.fragment.ExerciseActionThreeFragment
import com.blackview.search.view.fragment.ExerciseActionTwoFragment
import com.blackview.search.view.fragment.ExerciseAmusementOneFragment
import com.blackview.search.view.fragment.ExerciseAmusementTwoFragment
import com.blackview.search.view.fragment.ExerciseBathroomOneFragment
import com.blackview.search.view.fragment.ExerciseBathroomThreeFragment
import com.blackview.search.view.fragment.ExerciseBathroomTwoFragment
import com.blackview.search.view.fragment.ExerciseBedRoomFiveFragment
import com.blackview.search.view.fragment.ExerciseBedRoomFourFragment
import com.blackview.search.view.fragment.ExerciseBedRoomOneFragment
import com.blackview.search.view.fragment.ExerciseBedRoomThreeFragment
import com.blackview.search.view.fragment.ExerciseBedRoomTwoFragment
import com.blackview.search.view.fragment.ExerciseBirthdayOneFragment
import com.blackview.search.view.fragment.ExerciseBirthdayThreeFragment
import com.blackview.search.view.fragment.ExerciseBirthdayTwoFragment
import com.blackview.search.view.fragment.ExerciseBodyFourFragment
import com.blackview.search.view.fragment.ExerciseBodyOneFragment
import com.blackview.search.view.fragment.ExerciseBodyThreeFragment
import com.blackview.search.view.fragment.ExerciseBodyTwoFragment
import com.blackview.search.view.fragment.ExerciseCareerFiveFragment
import com.blackview.search.view.fragment.ExerciseCareerFourFragment
import com.blackview.search.view.fragment.ExerciseCareerOneFragment
import com.blackview.search.view.fragment.ExerciseCareerThreeFragment
import com.blackview.search.view.fragment.ExerciseCareerTwoFragment
import com.blackview.search.view.fragment.ExerciseClothFiveFragment
import com.blackview.search.view.fragment.ExerciseClothFourFragment
import com.blackview.search.view.fragment.ExerciseClothOneFragment
import com.blackview.search.view.fragment.ExerciseClothSixFragment
import com.blackview.search.view.fragment.ExerciseClothThreeFragment
import com.blackview.search.view.fragment.ExerciseClothTwoFragment
import com.blackview.search.view.fragment.ExerciseConcertFourFragment
import com.blackview.search.view.fragment.ExerciseConcertOneFragment
import com.blackview.search.view.fragment.ExerciseConcertThreeFragment
import com.blackview.search.view.fragment.ExerciseConcertTwoFragment
import com.blackview.search.view.fragment.ExerciseConstructionOneFragment
import com.blackview.search.view.fragment.ExerciseConstructionThreeFragment
import com.blackview.search.view.fragment.ExerciseConstructionTwoFragment
import com.blackview.search.view.fragment.ExerciseEmotionFourFragment
import com.blackview.search.view.fragment.ExerciseEmotionOneFragment
import com.blackview.search.view.fragment.ExerciseEmotionThreeFragment
import com.blackview.search.view.fragment.ExerciseEmotionTwoFragment
import com.blackview.search.view.fragment.ExerciseFruitOneFragment
import com.blackview.search.view.fragment.ExerciseFruitThreeFragment
import com.blackview.search.view.fragment.ExerciseFruitTwoFragment
import com.blackview.search.view.fragment.ExerciseHospitalOneFragment
import com.blackview.search.view.fragment.ExerciseHospitalThreeFragment
import com.blackview.search.view.fragment.ExerciseHospitalTwoFragment
import com.blackview.search.view.fragment.ExerciseKitchenFourFragment
import com.blackview.search.view.fragment.ExerciseKitchenOneFragment
import com.blackview.search.view.fragment.ExerciseKitchenThreeFragment
import com.blackview.search.view.fragment.ExerciseKitchenTwoFragment
import com.blackview.search.view.fragment.ExerciseNutOneFragment
import com.blackview.search.view.fragment.ExerciseRoomFourFragment
import com.blackview.search.view.fragment.ExerciseRoomOneFragment
import com.blackview.search.view.fragment.ExerciseRoomThreeFragment
import com.blackview.search.view.fragment.ExerciseRoomTwoFragment
import com.blackview.search.view.fragment.ExerciseSchoolFourFragment
import com.blackview.search.view.fragment.ExerciseSchoolOneFragment
import com.blackview.search.view.fragment.ExerciseSchoolThreeFragment
import com.blackview.search.view.fragment.ExerciseSchoolTwoFragment
import com.blackview.search.view.fragment.ExerciseSignOneFragment
import com.blackview.search.view.fragment.ExerciseSignTwoFragment
import com.blackview.search.view.fragment.ExerciseStreetFiveFragment
import com.blackview.search.view.fragment.ExerciseStreetFourFragment
import com.blackview.search.view.fragment.ExerciseStreetOneFragment
import com.blackview.search.view.fragment.ExerciseStreetSixFragment
import com.blackview.search.view.fragment.ExerciseStreetThreeFragment
import com.blackview.search.view.fragment.ExerciseStreetTwoFragment
import com.blackview.search.view.fragment.ExerciseStudyOneFragment
import com.blackview.search.view.fragment.ExerciseStudyThreeFragment
import com.blackview.search.view.fragment.ExerciseStudyTwoFragment
import com.blackview.search.view.fragment.ExerciseSupermarketFiveFragment
import com.blackview.search.view.fragment.ExerciseSupermarketFourFragment
import com.blackview.search.view.fragment.ExerciseSupermarketOneFragment
import com.blackview.search.view.fragment.ExerciseSupermarketSixFragment
import com.blackview.search.view.fragment.ExerciseSupermarketThreeFragment
import com.blackview.search.view.fragment.ExerciseSupermarketTwoFragment
import com.blackview.search.view.fragment.ExerciseToyFourFragment
import com.blackview.search.view.fragment.ExerciseToyOneFragment
import com.blackview.search.view.fragment.ExerciseToyThreeFragment
import com.blackview.search.view.fragment.ExerciseToyTwoFragment
import com.blackview.search.view.fragment.ExerciseVegetableFourFragment
import com.blackview.search.view.fragment.ExerciseVegetableOneFragment
import com.blackview.search.view.fragment.ExerciseVegetableThreeFragment
import com.blackview.search.view.fragment.ExerciseVegetableTwoFragment
import com.blackview.search.view.fragment.ExerciseVehicleFiveFragment
import com.blackview.search.view.fragment.ExerciseVehicleFourFragment
import com.blackview.search.view.fragment.ExerciseVehicleOneFragment
import com.blackview.search.view.fragment.ExerciseVehicleThreeFragment
import com.blackview.search.view.fragment.ExerciseVehicleTwoFragment
import com.blackview.search.view.fragment.ExerciseWashRoomOneFragment
import com.blackview.search.view.fragment.ExerciseWashRoomThreeFragment
import com.blackview.search.view.fragment.ExerciseWashRoomTwoFragment
import com.blackview.search.view.fragment.StudyActionFiveFragment
import com.blackview.search.view.fragment.StudyActionFourFragment
import com.blackview.search.view.fragment.StudyActionOneFragment
import com.blackview.search.view.fragment.StudyActionThreeFragment
import com.blackview.search.view.fragment.StudyActionTwoFragment
import com.blackview.search.view.fragment.StudyAmusementOneFragment
import com.blackview.search.view.fragment.StudyAmusementTwoFragment
import com.blackview.search.view.fragment.StudyBathroomOneFragment
import com.blackview.search.view.fragment.StudyBathroomThreeFragment
import com.blackview.search.view.fragment.StudyBathroomTwoFragment
import com.blackview.search.view.fragment.StudyBedRoomFiveFragment
import com.blackview.search.view.fragment.StudyBedRoomFourFragment
import com.blackview.search.view.fragment.StudyBedRoomOneFragment
import com.blackview.search.view.fragment.StudyBedRoomThreeFragment
import com.blackview.search.view.fragment.StudyBedRoomTwoFragment
import com.blackview.search.view.fragment.StudyBirthdayOneFragment
import com.blackview.search.view.fragment.StudyBirthdayThreeFragment
import com.blackview.search.view.fragment.StudyBirthdayTwoFragment
import com.blackview.search.view.fragment.StudyBodyFourFragment
import com.blackview.search.view.fragment.StudyBodyOneFragment
import com.blackview.search.view.fragment.StudyBodyThreeFragment
import com.blackview.search.view.fragment.StudyBodyTwoFragment
import com.blackview.search.view.fragment.StudyCareerFiveFragment
import com.blackview.search.view.fragment.StudyCareerFourFragment
import com.blackview.search.view.fragment.StudyCareerOneFragment
import com.blackview.search.view.fragment.StudyCareerThreeFragment
import com.blackview.search.view.fragment.StudyCareerTwoFragment
import com.blackview.search.view.fragment.StudyClothFiveFragment
import com.blackview.search.view.fragment.StudyClothFourFragment
import com.blackview.search.view.fragment.StudyClothOneFragment
import com.blackview.search.view.fragment.StudyClothSixFragment
import com.blackview.search.view.fragment.StudyClothThreeFragment
import com.blackview.search.view.fragment.StudyClothTwoFragment
import com.blackview.search.view.fragment.StudyConcertFourFragment
import com.blackview.search.view.fragment.StudyConcertOneFragment
import com.blackview.search.view.fragment.StudyConcertThreeFragment
import com.blackview.search.view.fragment.StudyConcertTwoFragment
import com.blackview.search.view.fragment.StudyConstructionOneFragment
import com.blackview.search.view.fragment.StudyConstructionThreeFragment
import com.blackview.search.view.fragment.StudyConstructionTwoFragment
import com.blackview.search.view.fragment.StudyEmotionFourFragment
import com.blackview.search.view.fragment.StudyEmotionOneFragment
import com.blackview.search.view.fragment.StudyEmotionThreeFragment
import com.blackview.search.view.fragment.StudyEmotionTwoFragment
import com.blackview.search.view.fragment.StudyFruitOneFragment
import com.blackview.search.view.fragment.StudyFruitThreeFragment
import com.blackview.search.view.fragment.StudyFruitTwoFragment
import com.blackview.search.view.fragment.StudyHospitalOneFragment
import com.blackview.search.view.fragment.StudyHospitalThreeFragment
import com.blackview.search.view.fragment.StudyKitchenFourFragment
import com.blackview.search.view.fragment.StudyKitchenOneFragment
import com.blackview.search.view.fragment.StudyKitchenThreeFragment
import com.blackview.search.view.fragment.StudyKitchenTwoFragment
import com.blackview.search.view.fragment.StudyNutOneFragment
import com.blackview.search.view.fragment.StudyRoomFourFragment
import com.blackview.search.view.fragment.StudyRoomOneFragment
import com.blackview.search.view.fragment.StudyRoomThreeFragment
import com.blackview.search.view.fragment.StudyRoomTwoFragment
import com.blackview.search.view.fragment.StudySchoolFourFragment
import com.blackview.search.view.fragment.StudySchoolOneFragment
import com.blackview.search.view.fragment.StudySchoolThreeFragment
import com.blackview.search.view.fragment.StudySchoolTwoFragment
import com.blackview.search.view.fragment.StudySignOneFragment
import com.blackview.search.view.fragment.StudySignTwoFragment
import com.blackview.search.view.fragment.StudyStreetFiveFragment
import com.blackview.search.view.fragment.StudyStreetFourFragment
import com.blackview.search.view.fragment.StudyStreetOneFragment
import com.blackview.search.view.fragment.StudyStreetSixFragment
import com.blackview.search.view.fragment.StudyStreetThreeFragment
import com.blackview.search.view.fragment.StudyStreetTwoFragment
import com.blackview.search.view.fragment.StudyStudyOneFragment
import com.blackview.search.view.fragment.StudyStudyThreeFragment
import com.blackview.search.view.fragment.StudyStudyTwoFragment
import com.blackview.search.view.fragment.StudySuperMarketFiveFragment
import com.blackview.search.view.fragment.StudySuperMarketFourFragment
import com.blackview.search.view.fragment.StudySuperMarketOneFragment
import com.blackview.search.view.fragment.StudySuperMarketSixFragment
import com.blackview.search.view.fragment.StudySuperMarketThreeFragment
import com.blackview.search.view.fragment.StudySuperMarketTwoFragment
import com.blackview.search.view.fragment.StudyToyFourFragment
import com.blackview.search.view.fragment.StudyToyOneFragment
import com.blackview.search.view.fragment.StudyToyThreeFragment
import com.blackview.search.view.fragment.StudyToyTwoFragment
import com.blackview.search.view.fragment.StudyVegetableFourFragment
import com.blackview.search.view.fragment.StudyVegetableOneFragment
import com.blackview.search.view.fragment.StudyVegetableThreeFragment
import com.blackview.search.view.fragment.StudyVegetableTwoFragment
import com.blackview.search.view.fragment.StudyVehicleFiveFragment
import com.blackview.search.view.fragment.StudyVehicleFourFragment
import com.blackview.search.view.fragment.StudyVehicleOneFragment
import com.blackview.search.view.fragment.StudyVehicleThreeFragment
import com.blackview.search.view.fragment.StudyVehicleTwoFragment
import com.blackview.search.view.fragment.StudyWashRoomOneFragment
import com.blackview.search.view.fragment.StudyWashRoomThreeFragment
import com.blackview.search.view.fragment.StudyWashRoomTwoFragment
import com.blackview.search.viewmodel.StudyExerciseViewModel

class StudyExerciseActivity : BaseActivity<StudyExerciseViewModel, ActivityStudyExerciseBinding>() {
    val studyFragments = mutableListOf<Fragment>()
    val exerciseFragments = mutableListOf<Fragment>()
    private var currentFragmentListener: VoiceAgainInterface? = null
    private var subject: SubjectBean? = null
    override fun initView(savedInstanceState: Bundle?) {
        mBinding.subjectVp.isUserInputEnabled = false
        subject = intent.extras?.getSerializable(Const.KEY_SUBJECT) as SubjectBean
        subject?.let {
            when (it.level) {
                Const.KEY_LEVEL_ONE -> {
                    resetL1Data(it)
                }

                Const.KEY_LEVEL_TWO -> {
                    resetL2Data(it)
                }

                Const.KEY_LEVEL_THREE -> {
                    resetL3Data(it)
                }
            }
            studyFragments.forEachIndexed { index, fra ->
                fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(index + 1))
                }
            }
            exerciseFragments.forEachIndexed { index, fra ->
                fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(index + 1))
                }
            }
            val studyAdapter = BaseFragmentPagerAdapter(this, studyFragments)
            val exerciseAdapter = BaseFragmentPagerAdapter(this, exerciseFragments)
            mBinding.subjectVp.apply {
                adapter = studyAdapter
            }
            mBinding.subjectVp.setCurrentItem((subject?.origin?.toInt() ?: 1) - 1, false)

            mBinding.nextIv.ktClickNoDelay {
                val currentItem = mBinding.subjectVp.currentItem
                mBinding.subjectVp.apply {
                    adapter = studyAdapter
                }
                if (currentItem + 1 < studyFragments.size) {
                    AudioPlayerManger.stop()
                    mBinding.subjectVp.setCurrentItem(currentItem + 1, false)
                }
                mBinding.rbStudy.isChecked = true
            }
            mBinding.previousIv.ktClickNoDelay {
                if (mBinding.subjectVp.currentItem - 1 >= 0) {
                    AudioPlayerManger.stop()
                    mBinding.subjectVp.currentItem = mBinding.subjectVp.currentItem - 1
                }
            }
            mBinding.LRadioGroup.setOnCheckedChangeListener { v, checkedId ->
                when (checkedId) {
                    R.id.rbStudy -> {
                        AudioPlayerManger.stop()
                        val currentItem = mBinding.subjectVp.currentItem
                        mBinding.subjectVp.apply {
                            adapter = studyAdapter
                        }
                        if (studyFragments.size > currentItem) {
                            mBinding.subjectVp.setCurrentItem(currentItem, false)
                        }
                    }

                    R.id.rbExercise -> {
                        AudioPlayerManger.stop()
                        val currentItem = mBinding.subjectVp.currentItem
                        mBinding.subjectVp.apply {
                            adapter = exerciseAdapter
                        }
                        if (exerciseFragments.size > currentItem) {
                            mBinding.subjectVp.setCurrentItem(currentItem, false)
                        }
                    }
                }
            }
        }
    }

    override fun initData() {

    }


    fun getStudySubject(origin: Int): SubjectBean {
        subject?.let {
            val tempSubject = it.copy()
            tempSubject.type = SubjectType.STUDY
            tempSubject.origin = origin
            val studyId =
                it.level + it.parentId.toString() + origin.toString() + SubjectType.STUDY.ordinal.toString()
            tempSubject.id = studyId
            return tempSubject
        }
        return SubjectBean()
    }

    fun getExerciseSubject(origin: Int): SubjectBean {
        subject?.let {
            val tempSubject = it.copy()
            tempSubject.type = SubjectType.EXERCISE
            tempSubject.origin = origin
            val studyId =
                it.level + it.parentId.toString() + origin.toString() + SubjectType.EXERCISE.ordinal.toString()
            tempSubject.id = studyId
            return tempSubject
        }
        return SubjectBean()
    }

    // 用于 Fragment 注册/注销监听
    fun registerFragmentListener(listener: VoiceAgainInterface) {
        currentFragmentListener = listener
    }

    fun unregisterFragmentListener() {
        currentFragmentListener = null
    }

    fun nextPage() {
        mBinding.nextIv.performClick()
    }

    override fun onEvent() {
        super.onEvent()
        mBinding.backIv.ktClick {
            AudioPlayerManger.stop()
            finish()
        }
        mBinding.voiceAgainIv.ktClick {
            if (!AudioPlayerManger.isPlay) {
                AudioPlayerManger.stop()
                currentFragmentListener?.onVoiceAgain()
            }
        }
        mBinding.rabbitIv.setImageDrawable(getDrawable(R.drawable.anim_rabbit))
        val anim = mBinding.rabbitIv.drawable as AnimationDrawable
        mBinding.rabbitIv.post {
            AudioPlayerManger.setGlobalCallBack(object : IPlayCallBack {
                override fun onStart(index: Int) {
                    anim.start()
                }

                override fun onEnd(index: Int) {
                    anim.stop()
                }
            })
        }
    }

    fun resetL1Data(it: SubjectBean) {
        when (it.parentId) {
            "0" -> {
                mutableListOf<Fragment>(
                    StudyBodyOneFragment(),
                    StudyBodyTwoFragment(),
                    StudyBodyThreeFragment(),
                    StudyBodyFourFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseBodyOneFragment(),
                    ExerciseBodyTwoFragment(),
                    ExerciseBodyThreeFragment(),
                    ExerciseBodyFourFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "1" -> {
                mutableListOf<Fragment>(
                    StudyEmotionOneFragment(),
                    StudyEmotionTwoFragment(),
                    StudyEmotionThreeFragment(),
                    StudyEmotionFourFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseEmotionOneFragment(),
                    ExerciseEmotionTwoFragment(),
                    ExerciseEmotionThreeFragment(),
                    ExerciseEmotionFourFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "2" -> {
                mutableListOf<Fragment>(
                    StudyActionOneFragment(),
                    StudyActionTwoFragment(),
                    StudyActionThreeFragment(),
                    StudyActionFourFragment(),
                    StudyActionFiveFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseActionOneFragment(),
                    ExerciseActionTwoFragment(),
                    ExerciseActionThreeFragment(),
                    ExerciseActionFourFragment(),
                    ExerciseActionFiveFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "3" -> {
                mutableListOf<Fragment>(
                    StudyToyOneFragment(),
                    StudyToyTwoFragment(),
                    StudyToyThreeFragment(),
                    StudyToyFourFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseToyOneFragment(),
                    ExerciseToyTwoFragment(),
                    ExerciseToyThreeFragment(),
                    ExerciseToyFourFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "4" -> {
                mutableListOf<Fragment>(
                    StudyRoomOneFragment(),
                    StudyRoomTwoFragment(),
                    StudyRoomThreeFragment(),
                    StudyRoomFourFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseRoomOneFragment(),
                    ExerciseRoomTwoFragment(),
                    ExerciseRoomThreeFragment(),
                    ExerciseRoomFourFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "5" -> {
                mutableListOf<Fragment>(
                    StudyBedRoomOneFragment(),
                    StudyBedRoomTwoFragment(),
                    StudyBedRoomThreeFragment(),
                    StudyBedRoomFourFragment(),
                    StudyBedRoomFiveFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseBedRoomOneFragment(),
                    ExerciseBedRoomTwoFragment(),
                    ExerciseBedRoomThreeFragment(),
                    ExerciseBedRoomFourFragment(),
                    ExerciseBedRoomFiveFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "6" -> {
                mutableListOf<Fragment>(
                    StudyClothOneFragment(),
                    StudyClothTwoFragment(),
                    StudyClothThreeFragment(),
                    StudyClothFourFragment(),
                    StudyClothFiveFragment(),
                    StudyClothSixFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseClothOneFragment(),
                    ExerciseClothTwoFragment(),
                    ExerciseClothThreeFragment(),
                    ExerciseClothFourFragment(),
                    ExerciseClothFiveFragment(),
                    ExerciseClothSixFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "7" -> {
                mutableListOf<Fragment>(
                    StudyStudyOneFragment(),
                    StudyStudyTwoFragment(),
                    StudyStudyThreeFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseStudyOneFragment(),
                    ExerciseStudyTwoFragment(),
                    ExerciseStudyThreeFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "8" -> {
                mutableListOf<Fragment>(
                    StudyKitchenOneFragment(),
                    StudyKitchenTwoFragment(),
                    StudyKitchenThreeFragment(),
                    StudyKitchenFourFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseKitchenOneFragment(),
                    ExerciseKitchenTwoFragment(),
                    ExerciseKitchenThreeFragment(),
                    ExerciseKitchenFourFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "9" -> {
                mutableListOf<Fragment>(
                    StudyBathroomOneFragment(),
                    StudyBathroomTwoFragment(),
                    StudyBathroomThreeFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseBathroomOneFragment(),
                    ExerciseBathroomTwoFragment(),
                    ExerciseBathroomThreeFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "10" -> {
                mutableListOf<Fragment>(
                    StudyWashRoomOneFragment(),
                    StudyWashRoomTwoFragment(),
                    StudyWashRoomThreeFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseWashRoomOneFragment(),
                    ExerciseWashRoomTwoFragment(),
                    ExerciseWashRoomThreeFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "11" -> {
                mutableListOf<Fragment>(
                    StudyBirthdayOneFragment(),
                    StudyBirthdayTwoFragment(),
                    StudyBirthdayThreeFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseBirthdayOneFragment(),
                    ExerciseBirthdayTwoFragment(),
                    ExerciseBirthdayThreeFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }
        }
    }

    fun resetL2Data(it: SubjectBean) {
        when (it.parentId) {
            "0" -> {
                mutableListOf<Fragment>(
                    StudyStreetOneFragment(),
                    StudyStreetTwoFragment(),
                    StudyStreetThreeFragment(),
                    StudyStreetFourFragment(),
                    StudyStreetFiveFragment(),
                    StudyStreetSixFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseStreetOneFragment(),
                    ExerciseStreetTwoFragment(),
                    ExerciseStreetThreeFragment(),
                    ExerciseStreetFourFragment(),
                    ExerciseStreetFiveFragment(),
                    ExerciseStreetSixFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "1" -> {
                mutableListOf<Fragment>(
                    StudyVehicleOneFragment(),
                    StudyVehicleTwoFragment(),
                    StudyVehicleThreeFragment(),
                    StudyVehicleFourFragment(),
                    StudyVehicleFiveFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseVehicleOneFragment(),
                    ExerciseVehicleTwoFragment(),
                    ExerciseVehicleThreeFragment(),
                    ExerciseVehicleFourFragment(),
                    ExerciseVehicleFiveFragment(),
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "2" -> {
                mutableListOf<Fragment>(
                    StudyConstructionOneFragment(),
                    StudyConstructionTwoFragment(),
                    StudyConstructionThreeFragment(),
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseConstructionOneFragment(),
                    ExerciseConstructionTwoFragment(),
                    ExerciseConstructionThreeFragment(),
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "3" -> {
                mutableListOf<Fragment>(
                    StudyHospitalOneFragment(),
                    StudyHospitalThreeFragment(),
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseHospitalOneFragment(),
                    ExerciseHospitalTwoFragment(),
                    ExerciseHospitalThreeFragment(),
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "4" -> {
                mutableListOf<Fragment>(
                    StudySchoolOneFragment(),
                    StudySchoolTwoFragment(),
                    StudySchoolThreeFragment(),
                    StudySchoolFourFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseSchoolOneFragment(),
                    ExerciseSchoolTwoFragment(),
                    ExerciseSchoolThreeFragment(),
                    ExerciseSchoolFourFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "5" -> {
                mutableListOf<Fragment>(
                    StudyCareerOneFragment(),
                    StudyCareerTwoFragment(),
                    StudyCareerThreeFragment(),
                    StudyCareerFourFragment(),
                    StudyCareerFiveFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseCareerOneFragment(),
                    ExerciseCareerTwoFragment(),
                    ExerciseCareerThreeFragment(),
                    ExerciseCareerFourFragment(),
                    ExerciseCareerFiveFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "6" -> {
                mutableListOf<Fragment>(
                    StudySuperMarketOneFragment(),
                    StudySuperMarketTwoFragment(),
                    StudySuperMarketThreeFragment(),
                    StudySuperMarketFourFragment(),
                    StudySuperMarketFiveFragment(),
                    StudySuperMarketSixFragment()
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseSupermarketOneFragment(),
                    ExerciseSupermarketTwoFragment(),
                    ExerciseSupermarketThreeFragment(),
                    ExerciseSupermarketFourFragment(),
                    ExerciseSupermarketFiveFragment(),
                    ExerciseSupermarketSixFragment()
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "7" -> {
                mutableListOf<Fragment>(
                    StudyVegetableOneFragment(),
                    StudyVegetableTwoFragment(),
                    StudyVegetableThreeFragment(),
                    StudyVegetableFourFragment(),
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseVegetableOneFragment(),
                    ExerciseVegetableTwoFragment(),
                    ExerciseVegetableThreeFragment(),
                    ExerciseVegetableFourFragment(),
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "8" -> {
                mutableListOf<Fragment>(
                    StudyFruitOneFragment(),
                    StudyFruitTwoFragment(),
                    StudyFruitThreeFragment(),
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseFruitOneFragment(),
                    ExerciseFruitTwoFragment(),
                    ExerciseFruitThreeFragment(),
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "9" -> {
                mutableListOf<Fragment>(
                    StudyNutOneFragment(),
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseNutOneFragment(),
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "10" -> {
                mutableListOf<Fragment>(
                    StudyConcertOneFragment(),
                    StudyConcertTwoFragment(),
                    StudyConcertThreeFragment(),
                    StudyConcertFourFragment(),
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseConcertOneFragment(),
                    ExerciseConcertTwoFragment(),
                    ExerciseConcertThreeFragment(),
                    ExerciseConcertFourFragment(),
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "11" -> {
                mutableListOf<Fragment>(
                    StudyAmusementOneFragment(),
                    StudyAmusementTwoFragment(),
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseAmusementOneFragment(),
                    ExerciseAmusementTwoFragment(),
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }

            "12" -> {
                mutableListOf<Fragment>(
                    StudySignOneFragment(),
                    StudySignTwoFragment(),
                ).apply {
                    studyFragments.addAll(this)
                }
                mutableListOf<Fragment>(
                    ExerciseSignOneFragment(),
                    ExerciseSignTwoFragment(),
                ).apply {
                    exerciseFragments.addAll(this)
                }
            }
        }
    }

    fun resetL3Data(it: SubjectBean) {
        when (it.parentId) {

        }
    }
}