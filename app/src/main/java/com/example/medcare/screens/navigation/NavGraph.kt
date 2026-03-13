package com.example.medcare.screens.navigation

import android.content.SharedPreferences
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.medcare.screens.class_objects.HospitalData
import com.example.medcare.screens.history.HistoryScreen
import com.example.medcare.screens.homeScreen.DoctorHomeScreen
import com.example.medcare.screens.homeScreen.HomeScreen
import com.example.medcare.screens.homeScreen.healthShop.Home.ShoppingHomePage
import com.example.medcare.screens.homeScreen.healthShop.MedicineDescription
import com.example.medcare.screens.homeScreen.healthShop.MedicineGrid
import com.example.medcare.screens.homeScreen.healthShop.cart.Cart
import com.example.medcare.screens.homeScreen.healthShop.cart.EmptyCart
import com.example.medcare.screens.homeScreen.healthShop.cart.FindingPharmacy
import com.example.medcare.screens.loginScreen.LoginScreen
import com.example.medcare.screens.profile.AccountSettings
import com.example.medcare.screens.profile.EmptyNotifications
import com.example.medcare.screens.profile.HealthHistory
import com.example.medcare.screens.profile.NotificationScreen
import com.example.medcare.screens.profile.PrescriptionHistory
import com.example.medcare.screens.profile.ProfileScreen
import com.example.medcare.screens.profile.Transactions
import com.example.medcare.screens.registerScreen.DoctorConfirmation
import com.example.medcare.screens.registerScreen.RegisterScreen
import com.example.medcare.screens.servicesScreen.ServicesScreen
import com.example.medcare.screens.servicesScreen.article.ArticleList
import com.example.medcare.screens.servicesScreen.article.ArticlePage
import com.example.medcare.screens.servicesScreen.article.DisplayArticle
import com.example.medcare.screens.servicesScreen.chatDoc.AppointmentSuccess
import com.example.medcare.screens.servicesScreen.chatDoc.Confirmation
import com.example.medcare.screens.servicesScreen.chatDoc.ConsultDoctorScreen
import com.example.medcare.screens.servicesScreen.chatDoc.DoctorDetails
import com.example.medcare.screens.servicesScreen.hospitals.HospitalDetails
import com.example.medcare.screens.servicesScreen.hospitals.HospitalMain
import com.example.medcare.screens.servicesScreen.hospitals.Map
import com.example.medcare.screens.servicesScreen.medicationReminder.MedicationHome
import com.example.medcare.screens.servicesScreen.medicationReminder.MedicationReminder
import com.example.medcare.screens.servicesScreen.medicationReminder.ReminderFilled
import com.example.medcare.screens.servicesScreen.specialization.Specialist
import com.example.medcare.screens.splashScreen.AuthSplashScreen
import com.example.medcare.screens.splashScreen.HPager
import com.example.medcare.screens.splashScreen.OtpPhone
import com.example.medcare.screens.splashScreen.Splashscreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(
    navHostController: NavHostController,
    sharedPreferences: SharedPreferences,
    modifier: Modifier
) {
    val isOnBoarded = sharedPreferences.getBoolean("isOnBoarded", false)
    val isPatientLoggedIn = sharedPreferences.getBoolean("isPatientLoggedIn", false)
    val isDoctorLoggedIn = sharedPreferences.getBoolean("isDoctorLoggedIn", false)
    val isRegistered = sharedPreferences.getBoolean("isRegistered", false)
    val isPatient = sharedPreferences.getBoolean("isPatient", false)
    val isDoctor = sharedPreferences.getBoolean("isDoctor", false)

    NavHost(navHostController, startDestination = NavRoute.Splash.path) {
        addHomeScreen(navHostController, this)
        addDoctorHomeScreen(navHostController, this, sharedPreferences)
        addSplashScreen(navHostController, this, isOnBoarded, isPatientLoggedIn, isDoctorLoggedIn,isRegistered, isPatient, isDoctor)
        addWalkthroughScreen(navHostController, this, sharedPreferences)
        addRegisterScreen(navHostController, this, sharedPreferences)
        addDoctorRegisterConfirmationScreen(navHostController, this)
        addLoginScreen(navHostController, this, sharedPreferences)
        addOTPScreen(navHostController, this)
        addProfileScreen(navHostController, this, sharedPreferences)
        addHistoryScreen(navHostController, this)
        addServicesScreen(navHostController, this)
        addAuthSplash(navHostController, this)
        addChatDocScreen(navHostController, this)
        addNotificationsScreen(navHostController, this)
        addClearNotiScreen(navHostController, this)
        addCartScreen(navHostController, this)
        addFindPharmaScreen(navHostController, this)
        addEmptyCartScreen(navHostController, this)
        addHealthShop(navHostController, this)
        addMedGrid(navHostController, this)
        addMedDesc(navHostController, this)
        addDocDtls(navHostController, this)
        addAppointmentScreen(navHostController, this)
        addAppointmentSuccessScreen(navHostController, this)
        addHospiDetailsScreen(navHostController, this)
        addHospitalScreen(navHostController, this)
        addHospiLocScreen(navHostController, this)
        addMedReminderScreen(navHostController, this)
        addMedicineScreen(navHostController, this)
        addSpecialistScreen(navHostController, this)
        addArticleHome(navHostController, this)
        addReadArticleScreen(navHostController, this)
        addArticleGridScreen(navHostController, this)
        addPrescriptionHistScreen(navHostController, this)
        addHealthHistScreen(navHostController, this)
        addTransactionScreen(navHostController, this)
        addAccSettScreen(navHostController, this)
//        addPharmacyPortalScreen(navHostController,this)
//        addPharmaRegisterScreen(navHostController,this)
        addSavedReminder(navHostController, this)
    }
}

fun addHomeScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
//                  isLoggedIn: Boolean,
//                  isRegistered: Boolean
) {
    navGraphBuilder.composable(
        route = NavRoute.Main.path,
//        arguments = listOf(
//            navArgument("userName") {
//                type = NavType.StringType
//                nullable = true
//                defaultValue = null
//            },
//            navArgument("email") {
//                type = NavType.StringType
//                nullable = true
//                defaultValue = null
//            }
//        )
    ) {
        HomeScreen(
            navigateToChatDoc = {
                navHostController.navigate(NavRoute.ChatDoc.path)
            },
            navigateToProfile = {
                navHostController.navigate(NavRoute.Profile.path) {
                    popUpTo(NavRoute.Main.path) {
                        inclusive = true
                    }
                }
            },
            navigateToNotifications = {
                navHostController.navigate(NavRoute.Notifications.path)
            },
            navigateToCart = {
                navHostController.navigate(NavRoute.Cart.path)
            },
            navigateToHealthShop = {
                navHostController.navigate(NavRoute.HealthShop.path)
            },
            navigateToHospital = {
                navHostController.navigate(NavRoute.hospital.path)
            },
            navigateToArticle = {
                navHostController.navigate(NavRoute.articleRead.path)
            },
//            userName = it.arguments?.getString("userName").toString(),
//            email = it.arguments?.getString("email").toString()
        )
    }
}

//fun addConsultDocComposableScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
//    navGraphBuilder.composable(NavRoute.ConsultDocComposable.path) {
//        ConsultDocComposable(
//            navigateToChatDoc = { navHostController.navigate(NavRoute.ChatDoc.path) }
//        )
//    }
//}


fun addDoctorHomeScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    sharedPreferences: SharedPreferences
) {
    navGraphBuilder.composable(NavRoute.DoctorMain.path) {
        DoctorHomeScreen(
            navigateToAuthSplash = {
                navHostController.navigate(NavRoute.AuthSplash.path) {
                    popUpTo(navHostController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                }
            },
            sharedPreferences = sharedPreferences
        )
    }
}

fun addSplashScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    isOnBoarded: Boolean,
    isPatientLoggedIn: Boolean,
    isDoctorLoggedIn: Boolean,
    isRegistered: Boolean,
    isPatient: Boolean,
    isDoctor: Boolean
) {
    navGraphBuilder.composable(
        route = NavRoute.Splash.path
    ) {
        Splashscreen(navigateToOnBoard = {
            if (isOnBoarded && isPatientLoggedIn && isPatient) {
                navHostController.navigate(NavRoute.Main.path)
            }
            else if (isOnBoarded && isDoctorLoggedIn && isDoctor) {
                navHostController.navigate(NavRoute.DoctorMain.path)
            }
//            else if (isOnBoarded && isRegistered) {
//                navHostController.navigate(NavRoute.Main.path)
//            }
            else if (isOnBoarded) {
                navHostController.navigate(NavRoute.AuthSplash.path)
            }
            else {
                navHostController.navigate(NavRoute.Walkthrough.path)
            }
        }
//            navigateToHome = {
//                navHostController.navigate(NavRoute.Main.path)
//            }
        )
    }
}

fun addWalkthroughScreen(
    navHostController: NavHostController, navGraphBuilder: NavGraphBuilder,
    sharedPreferences: SharedPreferences,
) {
    navGraphBuilder.composable(
        route = NavRoute.Walkthrough.path
    ) {
        HPager(
            navigateToAuthSplash = {
                navHostController.navigate(NavRoute.AuthSplash.path)
            }, sharedPreferences
        )
    }
}

fun addProfileScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    sharedPreferences: SharedPreferences
) {
    navGraphBuilder.composable(
        route = NavRoute.Profile.path, arguments = listOf(navArgument("userName") {
            type = NavType.StringType
            nullable = true
            defaultValue = null
        }, navArgument("email") {
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ) {
        ProfileScreen(
            back = { navHostController.popBackStack() },
            navigateToPresHist = {
                navHostController.navigate(NavRoute.presHist.path)
            },
            navigateToHealthHist = {
                navHostController.navigate(NavRoute.healthHist.path)
            },
            navigateToTransactions = {
                navHostController.navigate(NavRoute.transactions.path)
            },
            navigateToAccSettings = {
                navHostController.navigate(NavRoute.accSett.path)
            },
            navigateToNotifications = {
                navHostController.navigate(NavRoute.Notifications.path)
            },
//            navigateToPharmaAdmin = {
//                navHostController.navigate(NavRoute.pharmaPortal.path)
//            },
            navigateToAuthSplash = {
                navHostController.navigate(NavRoute.AuthSplash.path) {
                    popUpTo(navHostController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                }
            },
            sharedPreferences = sharedPreferences
//            userName = it.arguments?.getString("userName").toString(),
//            email = it.arguments?.getString("email").toString(),
        )
    }
}

fun addServicesScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Services.path
    ) {
        ServicesScreen(
            back = { navHostController.popBackStack() }, navHostController
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun addHistoryScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.History.path
    ) {
        HistoryScreen(
            navigateToChatDoc = { navHostController.navigate(NavRoute.ChatDoc.path) })
    }
}

fun addAuthSplash(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.AuthSplash.path
    ) {
        AuthSplashScreen(
//            navigateToHome = {navHostController.navigate(NavRoute.Main.path.plus("?&userName&email"))},
            navigateToRegister = { navHostController.navigate(NavRoute.Register.path) },
            navigateToLogin = { navHostController.navigate(NavRoute.Login.path) })
    }
}

fun addRegisterScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    sharedPreferences: SharedPreferences
) {
    navGraphBuilder.composable(
        route = NavRoute.Register.path,
    ) {
        RegisterScreen(
            navigateToLoginScreen = {
            navHostController.navigate(NavRoute.Login.path)
        }, navigateToHomeScreen = {
//                userName, email ->
            navHostController.navigate(NavRoute.Main.path)
        }, navigateToConfirmationScreen = {
            navHostController.navigate(NavRoute.doctorRegisterConfirmation.path)
        }, sharedPreferences
        )
    }
}

fun addDoctorRegisterConfirmationScreen(
    navHostController: NavHostController, navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.doctorRegisterConfirmation.path
    ) {
        DoctorConfirmation(
            navigateToLoginScreen = {navHostController.navigate(NavRoute.Login.path)}
        )
    }
}

fun addLoginScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    sharedPreferences: SharedPreferences
) {
    navGraphBuilder.composable(
        route = NavRoute.Login.path
    ) {
        LoginScreen(
            navigateToHomeScreen = {
//                userName,email ->
            navHostController.navigate(NavRoute.Main.path)
        },
            navigateToRegister = { navHostController.navigate(NavRoute.Register.path) },
            navigateToDoctorHome = { navHostController.navigate(NavRoute.DoctorMain.path) },
            sharedPreferences
        )
    }
}

fun addOTPScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.OTP.path
    ) {
        OtpPhone()
    }
}

fun addChatDocScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.ChatDoc.path
    ) {
        ConsultDoctorScreen(back = { navHostController.popBackStack() },
            navigateToDocDtls = { doctorName, spec, gender ->
            navHostController.navigate(NavRoute.DocDtls.path.plus("&name=$doctorName&specialization=$spec&gender=$gender"))
        })
    }
}

fun addNotificationsScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Notifications.path
    ) {
        NotificationScreen(
            back = { navHostController.popBackStack() },
            navigateToClearNotifications = {
                navHostController.navigate(NavRoute.clearNoti.path)
            })
    }
}

fun addCartScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Cart.path
    ) {
        Cart(back = { navHostController.popBackStack() }, navigateToFindingPharma = {
            navHostController.navigate(NavRoute.findingPharma.path)
        })
    }
}

fun addHealthShop(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.HealthShop.path
    ) {
        ShoppingHomePage(back = { navHostController.popBackStack() }, navigateToMedGrid = {
            navHostController.navigate(NavRoute.medGrid.path)
        }, navigateToMedDesc = {
            navHostController.navigate(NavRoute.medDesc.path)
        }, navigateToCart = {
            navHostController.navigate(NavRoute.Cart.path)
        })
    }
}

fun addMedGrid(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.medGrid.path
    ) {
        MedicineGrid(back = { navHostController.popBackStack() }, navigateToMedDesc = {
            navHostController.navigate(NavRoute.medDesc.path)
        }, navigateToCart = {
            navHostController.navigate(NavRoute.Cart.path)
        })
    }
}

fun addMedDesc(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.medDesc.path
    ) {
        MedicineDescription(back = { navHostController.popBackStack() }, navigateToCart = {
            navHostController.navigate(NavRoute.Cart.path)
        })
    }
}

fun addHospitalScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.hospital.path
    ) {

        HospitalMain(back = { navHostController.popBackStack() }, navigateToDetail = {
            navHostController.navigate(NavRoute.hospiDtls.path)
        }, navigateToMap = {
            navHostController.navigate(NavRoute.hospiMap.path)
        })
    }
}

fun addHospiDetailsScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.hospiDtls.path
    ) {
        val item = HospitalData.data.first()
        HospitalDetails(
            item, navigateToMap = {
                navHostController.navigate(NavRoute.hospiMap.path)
            })
    }
}

fun addHospiLocScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.hospiMap.path
    ) {
        Map()
    }
}

//fun addHospitalLayoutScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
//    navGraphBuilder.composable(
//        route = NavRoute.hospiLayout.path
//    ) {
//        HospitalLayout(navigateToHospiDtls = {
//            navHostController.navigate(NavRoute.hospiDtls.path)
//        })
//    }
//}


@RequiresApi(Build.VERSION_CODES.O)
fun addDocDtls(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.DocDtls.path,
        arguments = listOf(
            navArgument("name") {
                type = NavType.StringType
                defaultValue = ""
            },
            navArgument("specialization") {
                type = NavType.StringType
                defaultValue = ""
            },
            navArgument("gender") {
                type = NavType.StringType
                defaultValue = ""
            }
        )
    ) {
        val doctorName = Uri.decode(it.arguments?.getString("name") ?: "")
        val doctorSpecialization = Uri.decode(it.arguments?.getString("specialization") ?: "")
        val doctorGender = Uri.decode(it.arguments?.getString("gender") ?: "")
        DoctorDetails(
            back = { navHostController.popBackStack() },
            navigateToAppointment = { doctorName, doctorSpecialization, doctorGender, date, hours ->
                navHostController.navigate(
                    NavRoute.Appointment.path.plus(
                        "/${doctorName}/${doctorSpecialization}/${doctorGender}/${date}/${hours}"
                    )
                )
            },
            name = doctorName,
            specialization = doctorSpecialization,
            gender = doctorGender
        )
    }
}


fun addAppointmentScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Appointment.path.plus(
            "/{doctorName}/{doctorSpecialization}/{doctorGender}/{date}/{hours}"
        ), arguments = listOf(
            navArgument("doctorName") {
                type = NavType.StringType
            },
            navArgument("doctorSpecialization") {
                type = NavType.StringType
            },
            navArgument("doctorGender") {
                type = NavType.StringType
            },
            navArgument("date") {
            type = NavType.StringType
        }, navArgument("hours") {
            type = NavType.StringType
        })
    ) {
        val doctorName = it.arguments?.getString("doctorName").toString()
        val doctorSpecialization = it.arguments?.getString("doctorSpecialization").toString()
        val doctorGender = it.arguments?.getString("doctorGender").toString()
        val appointmentDate = Uri.decode(it.arguments?.getString("date").toString())
        val appointmentHours = Uri.decode(it.arguments?.getString("hours").toString())
        Confirmation(
            back = { navHostController.popBackStack() },
            navigateToAppointmentSuccess =
                { navHostController.navigate(NavRoute.appointmentSuccess.path) },
            doctorName = doctorName,
            doctorSpecialization = doctorSpecialization,
            doctorGender = doctorGender,
            appointmentDate = appointmentDate,
            appointmentHours = appointmentHours
        )
    }
}

fun addAppointmentSuccessScreen(
    navHostController: NavHostController, navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.appointmentSuccess.path
    ) {
        AppointmentSuccess(
            navigateToHistory = {
                navHostController.navigate(NavRoute.History.path) {
                    popUpTo(NavRoute.Main.path) {
                        inclusive = true
                    }
                }
            })
    }
}

fun addMedReminderScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.medReminder.path
    ) {
        MedicationHome(back = { navHostController.popBackStack() }, navigateToAddMed = {
            navHostController.navigate(NavRoute.addMed.path)
        })
    }
}

fun addMedicineScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.addMed.path
    ) {
        MedicationReminder(
            back = { navHostController.popBackStack() },
            navigateToSavedReminder = { medName, dosage, timings ->
                navHostController.navigate(
                    NavRoute.savedReminder.path.plus(
                        "/$medName/$dosage/$timings"
                    )
                )
            })
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun addSavedReminder(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.savedReminder.path.plus(
            "/{medName}/{dosage}/{timings}"
        ), arguments = listOf(navArgument("medName") {
            type = NavType.StringType
        }, navArgument("dosage") {
            type = NavType.StringType
        }, navArgument("timings") {
            type = NavType.StringType
        })
    ) {
        val medName: String = it.arguments?.getString("medName").toString()
        val dosage: String = it.arguments?.getString("dosage").toString()
        val timings: String = it.arguments?.getString("timings").toString()
        ReminderFilled(
            medName, dosage, timings, back = { navHostController.popBackStack() })
    }
}

fun addSpecialistScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.specialist.path
    ) {
        Specialist(
            back = { navHostController.popBackStack() })
    }
}

fun addArticleHome(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.articleHome.path
    ) {
        ArticleList(back = { navHostController.popBackStack() }, navigateToArticle = {
            navHostController.navigate(NavRoute.articleRead.path)
        }, navigateToArticleGrid = {
            navHostController.navigate(NavRoute.articleGrid.path)
        })
    }
}

fun addReadArticleScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.articleRead.path
    ) {
        DisplayArticle(
            back = { navHostController.popBackStack() })
    }
}

fun addArticleGridScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.articleGrid.path
    ) {
        ArticlePage(
            back = { navHostController.popBackStack() },
            navigateToArticle = {
                navHostController.navigate(NavRoute.articleRead.path)
            },
        )
    }
}

fun addFindPharmaScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.findingPharma.path
    ) {
        FindingPharmacy(
            navigateToEmptyCart = {
                navHostController.navigate(NavRoute.emptyCart.path)
            })
    }
}

fun addEmptyCartScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.emptyCart.path
    ) {
        EmptyCart(back = { navHostController.popBackStack() }, navigateToHealthShop = {
            navHostController.navigate(NavRoute.HealthShop.path) {
                popUpTo(NavRoute.HealthShop.path) {
                    inclusive = true
                }
            }
        })
    }
}

fun addPrescriptionHistScreen(
    navHostController: NavHostController, navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.presHist.path
    ) {
        PrescriptionHistory(
            back = { navHostController.popBackStack() })
    }
}

fun addHealthHistScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        NavRoute.healthHist.path
    ) {
        HealthHistory(
            back = { navHostController.popBackStack() })
    }
}

fun addTransactionScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.transactions.path
    ) {
        Transactions(
            back = { navHostController.popBackStack() })
    }
}

fun addAccSettScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.accSett.path
    ) {
        AccountSettings(
            back = { navHostController.popBackStack() })
    }
}

fun addClearNotiScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.clearNoti.path
    ) {
        EmptyNotifications(
            navigateToHome = {
                navHostController.navigate(NavRoute.Main.path) {
                    popUpTo(NavRoute.Main.path) {
                        inclusive = true
                    }
                }
            })
    }
}

//fun addPharmacyPortalScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
//    navGraphBuilder.composable(
//        route = NavRoute.pharmaPortal.path
//    ) {
//        AdminCred(
//            navigateToPharmaRegister = {
//                navHostController.navigate(NavRoute.pharmaRegister.path)
//            }
//        )
//    }
//}
//
//fun addPharmaRegisterScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
//    navGraphBuilder.composable(
//        route = NavRoute.pharmaRegister.path
//    ) {
//        RegisterPharma()
//    }
//}