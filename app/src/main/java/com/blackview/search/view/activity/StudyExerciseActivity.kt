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
import com.blackview.search.view.fragment.ExerciseClothFiveFragment
import com.blackview.search.view.fragment.ExerciseClothFourFragment
import com.blackview.search.view.fragment.ExerciseClothOneFragment
import com.blackview.search.view.fragment.ExerciseClothSixFragment
import com.blackview.search.view.fragment.ExerciseClothThreeFragment
import com.blackview.search.view.fragment.ExerciseClothTwoFragment
import com.blackview.search.view.fragment.ExerciseEmotionFourFragment
import com.blackview.search.view.fragment.ExerciseEmotionOneFragment
import com.blackview.search.view.fragment.ExerciseEmotionThreeFragment
import com.blackview.search.view.fragment.ExerciseEmotionTwoFragment
import com.blackview.search.view.fragment.ExerciseKitchenFourFragment
import com.blackview.search.view.fragment.ExerciseKitchenOneFragment
import com.blackview.search.view.fragment.ExerciseKitchenThreeFragment
import com.blackview.search.view.fragment.ExerciseKitchenTwoFragment
import com.blackview.search.view.fragment.ExerciseRoomFourFragment
import com.blackview.search.view.fragment.ExerciseRoomOneFragment
import com.blackview.search.view.fragment.ExerciseRoomThreeFragment
import com.blackview.search.view.fragment.ExerciseRoomTwoFragment
import com.blackview.search.view.fragment.ExerciseStreetFiveFragment
import com.blackview.search.view.fragment.ExerciseStreetFourFragment
import com.blackview.search.view.fragment.ExerciseStreetOneFragment
import com.blackview.search.view.fragment.ExerciseStreetSixFragment
import com.blackview.search.view.fragment.ExerciseStreetThreeFragment
import com.blackview.search.view.fragment.ExerciseStreetTwoFragment
import com.blackview.search.view.fragment.ExerciseStudyOneFragment
import com.blackview.search.view.fragment.ExerciseStudyThreeFragment
import com.blackview.search.view.fragment.ExerciseStudyTwoFragment
import com.blackview.search.view.fragment.ExerciseToyFourFragment
import com.blackview.search.view.fragment.ExerciseToyOneFragment
import com.blackview.search.view.fragment.ExerciseToyThreeFragment
import com.blackview.search.view.fragment.ExerciseToyTwoFragment
import com.blackview.search.view.fragment.ExerciseWashRoomOneFragment
import com.blackview.search.view.fragment.ExerciseWashRoomThreeFragment
import com.blackview.search.view.fragment.ExerciseWashRoomTwoFragment
import com.blackview.search.view.fragment.StudyActionFiveFragment
import com.blackview.search.view.fragment.StudyActionFourFragment
import com.blackview.search.view.fragment.StudyActionOneFragment
import com.blackview.search.view.fragment.StudyActionThreeFragment
import com.blackview.search.view.fragment.StudyActionTwoFragment
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
import com.blackview.search.view.fragment.StudyClothFiveFragment
import com.blackview.search.view.fragment.StudyClothFourFragment
import com.blackview.search.view.fragment.StudyClothOneFragment
import com.blackview.search.view.fragment.StudyClothSixFragment
import com.blackview.search.view.fragment.StudyClothThreeFragment
import com.blackview.search.view.fragment.StudyClothTwoFragment
import com.blackview.search.view.fragment.StudyEmotionFourFragment
import com.blackview.search.view.fragment.StudyEmotionOneFragment
import com.blackview.search.view.fragment.StudyEmotionThreeFragment
import com.blackview.search.view.fragment.StudyEmotionTwoFragment
import com.blackview.search.view.fragment.StudyKitchenFourFragment
import com.blackview.search.view.fragment.StudyKitchenOneFragment
import com.blackview.search.view.fragment.StudyKitchenThreeFragment
import com.blackview.search.view.fragment.StudyKitchenTwoFragment
import com.blackview.search.view.fragment.StudyRoomFourFragment
import com.blackview.search.view.fragment.StudyRoomOneFragment
import com.blackview.search.view.fragment.StudyRoomThreeFragment
import com.blackview.search.view.fragment.StudyRoomTwoFragment
import com.blackview.search.view.fragment.StudyStreetFiveFragment
import com.blackview.search.view.fragment.StudyStreetFourFragment
import com.blackview.search.view.fragment.StudyStreetOneFragment
import com.blackview.search.view.fragment.StudyStreetSixFragment
import com.blackview.search.view.fragment.StudyStreetThreeFragment
import com.blackview.search.view.fragment.StudyStreetTwoFragment
import com.blackview.search.view.fragment.StudyStudyOneFragment
import com.blackview.search.view.fragment.StudyStudyThreeFragment
import com.blackview.search.view.fragment.StudyStudyTwoFragment
import com.blackview.search.view.fragment.StudyToyFourFragment
import com.blackview.search.view.fragment.StudyToyOneFragment
import com.blackview.search.view.fragment.StudyToyThreeFragment
import com.blackview.search.view.fragment.StudyToyTwoFragment
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
                val studyBodyOneFra = StudyBodyOneFragment()
                studyBodyOneFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(1))
                }
                studyFragments.add(studyBodyOneFra)

                val studyBodyTwoFra = StudyBodyTwoFragment()
                studyBodyTwoFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(2))
                }
                studyFragments.add(studyBodyTwoFra)

                val studyBodyThreeFra = StudyBodyThreeFragment()
                studyBodyThreeFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(3))
                }
                studyFragments.add(studyBodyThreeFra)

                val studyBodyFourFra = StudyBodyFourFragment()
                studyBodyFourFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(4))
                }
                studyFragments.add(studyBodyFourFra)

                val exerciseBodyOneFra = ExerciseBodyOneFragment()
                exerciseBodyOneFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(1))
                }
                exerciseFragments.add(exerciseBodyOneFra)

                val exerciseBodyTwoFra = ExerciseBodyTwoFragment()
                exerciseBodyTwoFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(2))
                }
                exerciseFragments.add(exerciseBodyTwoFra)

                val exerciseBodyThreeFra = ExerciseBodyThreeFragment()
                exerciseBodyThreeFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(3))
                }
                exerciseFragments.add(exerciseBodyThreeFra)

                val exerciseBodyFourFra = ExerciseBodyFourFragment()
                exerciseBodyFourFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(4))
                }
                exerciseFragments.add(exerciseBodyFourFra)
            }

            "1" -> {
                val studyEmotionOneFra = StudyEmotionOneFragment()
                studyEmotionOneFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(1))
                }
                studyFragments.add(studyEmotionOneFra)

                val studyEmotionTwoFra = StudyEmotionTwoFragment()
                studyEmotionTwoFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(2))
                }
                studyFragments.add(studyEmotionTwoFra)

                val studyEmotionThreeFra = StudyEmotionThreeFragment()
                studyEmotionThreeFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(3))
                }
                studyFragments.add(studyEmotionThreeFra)

                val studyEmotionFourFra = StudyEmotionFourFragment()
                studyEmotionFourFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(4))
                }
                studyFragments.add(studyEmotionFourFra)

                val exerciseEmotionOneFra = ExerciseEmotionOneFragment()
                exerciseEmotionOneFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(1))
                }
                exerciseFragments.add(exerciseEmotionOneFra)

                val exerciseEmotionTwoFra = ExerciseEmotionTwoFragment()
                exerciseEmotionTwoFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(2))
                }
                exerciseFragments.add(exerciseEmotionTwoFra)

                val exerciseEmotionThreeFra = ExerciseEmotionThreeFragment()
                exerciseEmotionThreeFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(3))
                }
                exerciseFragments.add(exerciseEmotionThreeFra)

                val exerciseEmotionFourFra = ExerciseEmotionFourFragment()
                exerciseEmotionFourFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(4))
                }
                exerciseFragments.add(exerciseEmotionFourFra)

            }

            "2" -> {
                val studyActionOneFra = StudyActionOneFragment()
                studyActionOneFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(1))
                }
                studyFragments.add(studyActionOneFra)

                val studyActionTwoFra = StudyActionTwoFragment()
                studyActionTwoFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(2))
                }
                studyFragments.add(studyActionTwoFra)

                val studyActionThreeFra = StudyActionThreeFragment()
                studyActionThreeFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(3))
                }
                studyFragments.add(studyActionThreeFra)

                val studyActionFourFra = StudyActionFourFragment()
                studyActionFourFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(4))
                }
                studyFragments.add(studyActionFourFra)

                val studyActionFiveFra = StudyActionFiveFragment()
                studyActionFiveFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(5))
                }
                studyFragments.add(studyActionFiveFra)

                val exerciseActionOneFra = ExerciseActionOneFragment()
                exerciseActionOneFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(1))
                }
                exerciseFragments.add(exerciseActionOneFra)

                val exerciseActionTwoFra = ExerciseActionTwoFragment()
                exerciseActionTwoFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(2))
                }
                exerciseFragments.add(exerciseActionTwoFra)

                val exerciseActionThreeFra = ExerciseActionThreeFragment()
                exerciseActionThreeFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(3))
                }
                exerciseFragments.add(exerciseActionThreeFra)

                val exerciseActionFourFra = ExerciseActionFourFragment()
                exerciseActionFourFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(4))
                }
                exerciseFragments.add(exerciseActionFourFra)

                val exerciseActionFiveFra = ExerciseActionFiveFragment()
                exerciseActionFiveFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(5))
                }
                exerciseFragments.add(exerciseActionFiveFra)
            }

            "3" -> {
                val studyToyOneFra = StudyToyOneFragment()
                studyToyOneFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(1))
                }
                studyFragments.add(studyToyOneFra)

                val studyToyTwoFra = StudyToyTwoFragment()
                studyToyTwoFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(2))
                }
                studyFragments.add(studyToyTwoFra)

                val study3Fra = StudyToyThreeFragment()
                study3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(3))
                }
                studyFragments.add(study3Fra)
                val study4Fra = StudyToyFourFragment()
                study4Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(4))
                }
                studyFragments.add(study4Fra)

                val exerciseToyOneFra = ExerciseToyOneFragment()
                exerciseToyOneFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(1))
                }
                exerciseFragments.add(exerciseToyOneFra)

                val exerciseToyTwoFra = ExerciseToyTwoFragment()
                exerciseToyTwoFra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(2))
                }
                exerciseFragments.add(exerciseToyTwoFra)

                val exercise3Fra = ExerciseToyThreeFragment()
                exercise3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(3))
                }
                exerciseFragments.add(exercise3Fra)

                val exercise4Fra = ExerciseToyFourFragment()
                exercise4Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(4))
                }
                exerciseFragments.add(exercise4Fra)
            }

            "4" -> {
                val study1Fra = StudyRoomOneFragment()
                study1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(1))
                }
                studyFragments.add(study1Fra)
                val study2Fra = StudyRoomTwoFragment()
                study2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(2))
                }
                studyFragments.add(study2Fra)
                val study3Fra = StudyRoomThreeFragment()
                study3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(3))
                }
                studyFragments.add(study3Fra)
                val study4Fra = StudyRoomFourFragment()
                study4Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(4))
                }
                studyFragments.add(study4Fra)

                val exercise1Fra = ExerciseRoomOneFragment()
                exercise1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(1))
                }
                exerciseFragments.add(exercise1Fra)
                val exercise2Fra = ExerciseRoomTwoFragment()
                exercise2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(2))
                }
                exerciseFragments.add(exercise2Fra)
                val exercise3Fra = ExerciseRoomThreeFragment()
                exercise3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(3))
                }
                exerciseFragments.add(exercise3Fra)
                val exercise4Fra = ExerciseRoomFourFragment()
                exercise4Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(4))
                }
                exerciseFragments.add(exercise4Fra)
            }

            "5" -> {
                val study1Fra = StudyBedRoomOneFragment()
                study1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(1))
                }
                studyFragments.add(study1Fra)
                val study2Fra = StudyBedRoomTwoFragment()
                study2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(2))
                }
                studyFragments.add(study2Fra)
                val study3Fra = StudyBedRoomThreeFragment()
                study3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(3))
                }
                studyFragments.add(study3Fra)
                val study4Fra = StudyBedRoomFourFragment()
                study4Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(4))
                }
                studyFragments.add(study4Fra)
                val study5Fra = StudyBedRoomFiveFragment()
                study5Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(5))
                }
                studyFragments.add(study5Fra)

                val exercise1Fra = ExerciseBedRoomOneFragment()
                exercise1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(1))
                }
                exerciseFragments.add(exercise1Fra)
                val exercise2Fra = ExerciseBedRoomTwoFragment()
                exercise2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(2))
                }
                exerciseFragments.add(exercise2Fra)
                val exercise3Fra = ExerciseBedRoomThreeFragment()
                exercise3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(3))
                }
                exerciseFragments.add(exercise3Fra)
                val exercise4Fra = ExerciseBedRoomFourFragment()
                exercise4Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(4))
                }
                exerciseFragments.add(exercise4Fra)
                val exercise5Fra = ExerciseBedRoomFiveFragment()
                exercise5Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(5))
                }
                exerciseFragments.add(exercise5Fra)
            }

            "6" -> {
                val study1Fra = StudyClothOneFragment()
                study1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(1))
                }
                studyFragments.add(study1Fra)
                val study2Fra = StudyClothTwoFragment()
                study2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(2))
                }
                studyFragments.add(study2Fra)
                val study3Fra = StudyClothThreeFragment()
                study3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(3))
                }
                studyFragments.add(study3Fra)
                val study4Fra = StudyClothFourFragment()
                study4Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(4))
                }
                studyFragments.add(study4Fra)
                val study5Fra = StudyClothFiveFragment()
                study5Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(5))
                }
                studyFragments.add(study5Fra)
                val study6Fra = StudyClothSixFragment()
                study6Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(6))
                }
                studyFragments.add(study6Fra)

                val exercise1Fra = ExerciseClothOneFragment()
                exercise1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(1))
                }
                exerciseFragments.add(exercise1Fra)
                val exercise2Fra = ExerciseClothTwoFragment()
                exercise2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(2))
                }
                exerciseFragments.add(exercise2Fra)
                val exercise3Fra = ExerciseClothThreeFragment()
                exercise3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(3))
                }
                exerciseFragments.add(exercise3Fra)
                val exercise4Fra = ExerciseClothFourFragment()
                exercise4Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(4))
                }
                exerciseFragments.add(exercise4Fra)
                val exercise5Fra = ExerciseClothFiveFragment()
                exercise5Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(5))
                }
                exerciseFragments.add(exercise5Fra)
                val exercise6Fra = ExerciseClothSixFragment()
                exercise6Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(6))
                }
                exerciseFragments.add(exercise6Fra)
            }

            "7" -> {
                val study1Fra = StudyStudyOneFragment()
                study1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(1))
                }
                studyFragments.add(study1Fra)
                val study2Fra = StudyStudyTwoFragment()
                study2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(2))
                }
                studyFragments.add(study2Fra)
                val study3Fra = StudyStudyThreeFragment()
                study3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(3))
                }
                studyFragments.add(study3Fra)
                val exercise1Fra = ExerciseStudyOneFragment()
                exercise1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(1))
                }
                exerciseFragments.add(exercise1Fra)
                val exercise2Fra = ExerciseStudyTwoFragment()
                exercise2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(2))
                }
                exerciseFragments.add(exercise2Fra)
                val exercise3Fra = ExerciseStudyThreeFragment()
                exercise3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(3))
                }
                exerciseFragments.add(exercise3Fra)
            }

            "8" -> {
                val study1Fra = StudyKitchenOneFragment()
                study1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(1))
                }
                studyFragments.add(study1Fra)
                val study2Fra = StudyKitchenTwoFragment()
                study2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(2))
                }
                studyFragments.add(study2Fra)
                val study3Fra = StudyKitchenThreeFragment()
                study3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(3))
                }
                studyFragments.add(study3Fra)
                val study4Fra = StudyKitchenFourFragment()
                study4Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(4))
                }
                studyFragments.add(study4Fra)
                val exercise1Fra = ExerciseKitchenOneFragment()
                exercise1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(1))
                }
                exerciseFragments.add(exercise1Fra)
                val exercise2Fra = ExerciseKitchenTwoFragment()
                exercise2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(2))
                }
                exerciseFragments.add(exercise2Fra)
                val exercise3Fra = ExerciseKitchenThreeFragment()
                exercise3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(3))
                }
                exerciseFragments.add(exercise3Fra)
                val exercise4Fra = ExerciseKitchenFourFragment()
                exercise4Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(4))
                }
                exerciseFragments.add(exercise4Fra)
            }

            "9" -> {
                val study1Fra = StudyBathroomOneFragment()
                study1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(1))
                }
                studyFragments.add(study1Fra)
                val study2Fra = StudyBathroomTwoFragment()
                study2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(2))
                }
                studyFragments.add(study2Fra)
                val study3Fra = StudyBathroomThreeFragment()
                study3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(3))
                }
                studyFragments.add(study3Fra)
                val exercise1Fra = ExerciseBathroomOneFragment()
                exercise1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(1))
                }
                exerciseFragments.add(exercise1Fra)
                val exercise2Fra = ExerciseBathroomTwoFragment()
                exercise2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(2))
                }
                exerciseFragments.add(exercise2Fra)
                val exercise3Fra = ExerciseBathroomThreeFragment()
                exercise3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(3))
                }
                exerciseFragments.add(exercise3Fra)
            }

            "10" -> {
                val study1Fra = StudyWashRoomOneFragment()
                study1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(1))
                }
                studyFragments.add(study1Fra)
                val study2Fra = StudyWashRoomTwoFragment()
                study2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(2))
                }
                studyFragments.add(study2Fra)
                val study3Fra = StudyWashRoomThreeFragment()
                study3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(2))
                }
                studyFragments.add(study3Fra)
                val exercise1Fra = ExerciseWashRoomOneFragment()
                exercise1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(1))
                }
                exerciseFragments.add(exercise1Fra)
                val exercise2Fra = ExerciseWashRoomTwoFragment()
                exercise2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(2))
                }
                exerciseFragments.add(exercise2Fra)
                val exercise3Fra = ExerciseWashRoomThreeFragment()
                exercise3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(3))
                }
                exerciseFragments.add(exercise3Fra)
            }

            "11" -> {
                val study1Fra = StudyBirthdayOneFragment()
                study1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(1))
                }
                studyFragments.add(study1Fra)
                val study2Fra = StudyBirthdayTwoFragment()
                study2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(2))
                }
                studyFragments.add(study2Fra)
                val study3Fra = StudyBirthdayThreeFragment()
                study3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(3))
                }
                studyFragments.add(study3Fra)
                val exercise1Fra = ExerciseBirthdayOneFragment()
                exercise1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(1))
                }
                exerciseFragments.add(exercise1Fra)
                val exercise2Fra = ExerciseBirthdayTwoFragment()
                exercise2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(2))
                }
                exerciseFragments.add(exercise2Fra)
                val exercise3Fra = ExerciseBirthdayThreeFragment()
                exercise3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(3))
                }
                exerciseFragments.add(exercise3Fra)
            }
        }
    }

    fun resetL2Data(it: SubjectBean) {
        when (it.parentId) {
            "0" -> {
                val study1Fra = StudyStreetOneFragment()
                study1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(1))
                }
                studyFragments.add(study1Fra)
                val study2Fra = StudyStreetTwoFragment()
                study2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(2))
                }
                studyFragments.add(study2Fra)
                val study3Fra = StudyStreetThreeFragment()
                study3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(3))
                }
                studyFragments.add(study3Fra)
                val study4Fra = StudyStreetFourFragment()
                study4Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(3))
                }
                studyFragments.add(study4Fra)
                val study5Fra = StudyStreetFiveFragment()
                study5Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(5))
                }
                studyFragments.add(study5Fra)
                val study6Fra = StudyStreetSixFragment()
                study6Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getStudySubject(6))
                }
                studyFragments.add(study6Fra)
                val exercise1Fra = ExerciseStreetOneFragment()
                exercise1Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(1))
                }
                exerciseFragments.add(exercise1Fra)
                val exercise2Fra = ExerciseStreetTwoFragment()
                exercise2Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(2))
                }
                exerciseFragments.add(exercise2Fra)
                val exercise3Fra = ExerciseStreetThreeFragment()
                exercise3Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(3))
                }
                exerciseFragments.add(exercise3Fra)
                val exercise4Fra = ExerciseStreetFourFragment()
                exercise4Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(4))
                }
                exerciseFragments.add(exercise4Fra)
                val exercise5Fra = ExerciseStreetFiveFragment()
                exercise5Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(5))
                }
                exerciseFragments.add(exercise5Fra)
                val exercise6Fra = ExerciseStreetSixFragment()
                exercise6Fra.arguments = Bundle().apply {
                    putSerializable(Const.KEY_SUBJECT, getExerciseSubject(6))
                }
                exerciseFragments.add(exercise6Fra)
            }
        }
    }

    fun resetL3Data(it: SubjectBean) {
        when (it.parentId) {

        }
    }
}