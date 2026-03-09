package com.example.medcare.screens.navigation

import android.content.SharedPreferences
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavArgs
import androidx.navigation.NavArgument
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.medcare.screens.article.ArticleList
import com.example.medcare.screens.article.ArticlePage
import com.example.medcare.screens.article.DisplayArticle
import com.example.medcare.screens.class_objects.HospitalData
import com.example.medcare.screens.healthShop.Home.ShoppingHomePage
import com.example.medcare.screens.healthShop.MedicineDescription
import com.example.medcare.screens.healthShop.MedicineGrid
import com.example.medcare.screens.healthShop.cart.Cart
import com.example.medcare.screens.healthShop.cart.EmptyCart
import com.example.medcare.screens.healthShop.cart.FindingPharmacy
import com.example.medcare.screens.history.HistoryScreen
import com.example.medcare.screens.homeScreen.DoctorHomeScreen
import com.example.medcare.screens.homeScreen.HomeScreen
import com.example.medcare.screens.hospitals.HospitalDetails
import com.example.medcare.screens.hospitals.HospitalMain
import com.example.medcare.screens.hospitals.Map
import com.example.medcare.screens.loginScreen.LoginScreen
import com.example.medcare.screens.medicationReminder.MedicationHome
import com.example.medcare.screens.medicationReminder.MedicationReminder
import com.example.medcare.screens.medicationReminder.ReminderFilled
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
import com.example.medcare.screens.servicesScreen.chatDoc.AppointmentSuccess
import com.example.medcare.screens.servicesScreen.chatDoc.ChatDoctorScreen
import com.example.medcare.screens.servicesScreen.chatDoc.Confirmation
import com.example.medcare.screens.servicesScreen.chatDoc.DoctorDetails
import com.example.medcare.screens.specialization.Specialist
import com.example.medcare.screens.splashScreen.AuthSplashScreen
import com.example.medcare.screens.splashScreen.HPager
import com.example.medcare.screens.splashScreen.OtpPhone
import com.example.medcare.screens.splashScreen.Splashscreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(
    navHostController: NavHostController,
    sharedPreferences: SharedPreferences,
    isLoggedIn: Boolean,
    isRegistered: Boolean,
    modifier: Modifier
) {
    val isOnBoarded = sharedPreferences.getBoolean("isOnBoarded", false)

    NavHost(navHostController, startDestination = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Splash.path) {
        _root_ide_package_.com.example.medcare.screens.navigation.addHomeScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addDoctorHomeScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addSplashScreen(
            navHostController,
            this,
            isOnBoarded,
            isLoggedIn,
            isRegistered
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addWalkthroughScreen(
            navHostController,
            this,
            sharedPreferences
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addRegisterScreen(
            navHostController,
            this,
            sharedPreferences
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addDoctorRegisterConfirmationScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addLoginScreen(
            navHostController,
            this,
            sharedPreferences
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addOTPScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addProfileScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addHistoryScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addServicesScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addAuthSplash(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addChatDocScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addNotificationsScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addClearNotiScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addCartScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addFindPharmaScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addEmptyCartScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addHealthShop(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addMedGrid(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addMedDesc(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addDocDtls(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addAppointmentScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addAppointmentSuccessScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addHospiDetailsScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addHospitalScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addHospiLocScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addMedReminderScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addMedicineScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addSpecialistScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addArticleHome(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addReadArticleScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addArticleGridScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addPrescriptionHistScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addHealthHistScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addTransactionScreen(
            navHostController,
            this
        )
        _root_ide_package_.com.example.medcare.screens.navigation.addAccSettScreen(
            navHostController,
            this
        )
//        addPharmacyPortalScreen(navHostController,this)
//        addPharmaRegisterScreen(navHostController,this)
        _root_ide_package_.com.example.medcare.screens.navigation.addSavedReminder(
            navHostController,
            this
        )
    }
}

fun addHomeScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
//                  isLoggedIn: Boolean,
//                  isRegistered: Boolean
) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Main.path,
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
        _root_ide_package_.com.example.medcare.screens.homeScreen.HomeScreen(
            navigateToChatDoc = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.ChatDoc.path)
            },
            navigateToProfile = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Profile.path) {
                    popUpTo(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Main.path) {
                        _root_ide_package_.androidx.navigation.PopUpToBuilder.inclusive = true
                    }
                }
            },
            navigateToNotifications = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Notifications.path)
            },
            navigateToCart = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Cart.path)
            },
            navigateToHealthShop = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.HealthShop.path)
            },
            navigateToHospital = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.hospital.path)
            },
            navigateToArticle = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.articleRead.path)
            },
//            userName = it.arguments?.getString("userName").toString(),
//            email = it.arguments?.getString("email").toString()
        )
    }
}


fun addDoctorHomeScreen(navHostController: NavHostController, navGrahBuilder: NavGraphBuilder) {
    navGrahBuilder.composable(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.DoctorMain.path) {
        _root_ide_package_.com.example.medcare.screens.homeScreen.DoctorHomeScreen()
    }
}

fun addSplashScreen(
    navHostController: NavHostController, navGraphBuilder: NavGraphBuilder,
    isOnBoarded: Boolean,
    isLoggedIn: Boolean,
    isRegistered: Boolean
) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Splash.path
    ) {
        _root_ide_package_.com.example.medcare.screens.splashScreen.Splashscreen(
            navigateToOnBoard = {
                if (isOnBoarded && isLoggedIn) {
                    navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Main.path)
                } else if (isOnBoarded && isRegistered) {
                    navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Main.path)
                } else if (isOnBoarded) {
                    navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.AuthSplash.path)
                } else {
                    navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Walkthrough.path)
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
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Walkthrough.path
    ) {
        _root_ide_package_.com.example.medcare.screens.splashScreen.HPager(
            navigateToAuthSplash = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.AuthSplash.path)
            },
            sharedPreferences
        )
    }
}

fun addProfileScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Profile.path,
        arguments = listOf(
            navArgument("userName") {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            },
            navArgument("email") {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            }
        )
    ) {
        _root_ide_package_.com.example.medcare.screens.profile.ProfileScreen(
            back = { navHostController.popBackStack() },
            navigateToPresHist = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.presHist.path)
            },
            navigateToHealthHist = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.healthHist.path)
            },
            navigateToTransactions = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.transactions.path)
            },
            navigateToAccSettings = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.accSett.path)
            },
            navigateToNotifications = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Notifications.path)
            },
//            navigateToPharmaAdmin = {
//                navHostController.navigate(NavRoute.pharmaPortal.path)
//            },
            navigateToAuthSplash = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.AuthSplash.path) {
                    popUpTo(navHostController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                }
            },
//            userName = it.arguments?.getString("userName").toString(),
//            email = it.arguments?.getString("email").toString(),
        )
    }
}

fun addServicesScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Services.path
    ) {
        _root_ide_package_.com.example.medcare.screens.servicesScreen.ServicesScreen(
            back = { navHostController.popBackStack() },
            navHostController
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun addHistoryScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.History.path
    ) {
        _root_ide_package_.com.example.medcare.screens.history.HistoryScreen(
            back = { navHostController.popBackStack() },
            navigateToChatDoc = { navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.ChatDoc.path) }
        )
    }
}

fun addAuthSplash(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.AuthSplash.path
    ) {
        _root_ide_package_.com.example.medcare.screens.splashScreen.AuthSplashScreen(
//            navigateToHome = {navHostController.navigate(NavRoute.Main.path.plus("?&userName&email"))},
            navigateToRegister = { navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Register.path) },
            navigateToLogin = { navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Login.path) }
        )
    }
}

fun addRegisterScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    sharedPreferences: SharedPreferences
) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Register.path,
    ) {
        _root_ide_package_.com.example.medcare.screens.registerScreen.RegisterScreen(
            navigateToLoginScreen = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Login.path)
            },
            navigateToHomeScreen = {
//                userName, email ->
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Main.path)
            },
            navigateToConfirmationScreen = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.doctorRegisterConfirmation.path)
            },
            sharedPreferences
        )
    }
}

fun addDoctorRegisterConfirmationScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.doctorRegisterConfirmation.path
    ) {
        _root_ide_package_.com.example.medcare.screens.registerScreen.DoctorConfirmation()
    }
}

fun addLoginScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    sharedPreferences: SharedPreferences
) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Login.path
    ) {
        _root_ide_package_.com.example.medcare.screens.loginScreen.LoginScreen(
            navigateToHomeScreen = {
//                userName,email ->
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Main.path)
            },
            navigateToRegister = { navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Register.path) },
            navigateToDoctorHome = { navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.DoctorMain.path) },
            sharedPreferences
        )
    }
}

fun addOTPScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.OTP.path
    ) {
        _root_ide_package_.com.example.medcare.screens.splashScreen.OtpPhone()
    }
}

fun addChatDocScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.ChatDoc.path
    ) {
        _root_ide_package_.com.example.medcare.screens.servicesScreen.chatDoc.ChatDoctorScreen(
            back = { navHostController.popBackStack() },
            navigateToDocDtls = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.DocDtls.path)
            }
        )
    }
}

fun addNotificationsScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Notifications.path
    ) {
        _root_ide_package_.com.example.medcare.screens.profile.NotificationScreen(
            back = { navHostController.popBackStack() },
            navigateToClearNotifications = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.clearNoti.path)
            }
        )
    }
}

fun addCartScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Cart.path
    ) {
        _root_ide_package_.com.example.medcare.screens.healthShop.cart.Cart(
            back = { navHostController.popBackStack() },
            navigateToFindingPharma = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.findingPharma.path)
            }
        )
    }
}

fun addHealthShop(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.HealthShop.path
    ) {
        _root_ide_package_.com.example.medcare.screens.healthShop.Home.ShoppingHomePage(
            back = { navHostController.popBackStack() },
            navigateToMedGrid = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.medGrid.path)
            },
            navigateToMedDesc = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.medDesc.path)
            },
            navigateToCart = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Cart.path)
            }
        )
    }
}

fun addMedGrid(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.medGrid.path
    ) {
        _root_ide_package_.com.example.medcare.screens.healthShop.MedicineGrid(
            back = { navHostController.popBackStack() },
            navigateToMedDesc = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.medDesc.path)
            },
            navigateToCart = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Cart.path)
            }
        )
    }
}

fun addMedDesc(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.medDesc.path
    ) {
        _root_ide_package_.com.example.medcare.screens.healthShop.MedicineDescription(
            back = { navHostController.popBackStack() },
            navigateToCart = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Cart.path)
            }
        )
    }
}

fun addHospitalScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.hospital.path
    ) {

        _root_ide_package_.com.example.medcare.screens.hospitals.HospitalMain(
            back = { navHostController.popBackStack() },
            navigateToDetail = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.hospiDtls.path)
            },
            navigateToMap = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.hospiMap.path)
            }
        )
    }
}

fun addHospiDetailsScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.hospiDtls.path
    ) {
        val item = _root_ide_package_.com.example.medcare.screens.class_objects.HospitalData.data.first()
        _root_ide_package_.com.example.medcare.screens.hospitals.HospitalDetails(
            item,
            navigateToMap = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.hospiMap.path)
            })
    }
}

fun addHospiLocScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.hospiMap.path
    ) {
        _root_ide_package_.com.example.medcare.screens.hospitals.Map()
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
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.DocDtls.path
    ) {
        _root_ide_package_.com.example.medcare.screens.servicesScreen.chatDoc.DoctorDetails(
            back = { navHostController.popBackStack() },
            navigateToAppointment = { date, hours ->
                navHostController.navigate(
                    _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Appointment.path.plus(
                        "/${date}/${hours}"
                    )
                )
            }
        )
    }
}


fun addAppointmentScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Appointment.path.plus("/{date}/{hours}"),
        arguments = listOf(
            navArgument("date") {
                type = NavType.StringType
            },
            navArgument("hours") {
                type = NavType.StringType
            }
        )
    ) {
        val appointmentDate = Uri.decode(it.arguments?.getString("date").toString())
        val appointmentHours = Uri.decode(it.arguments?.getString("hours").toString())
        _root_ide_package_.com.example.medcare.screens.servicesScreen.chatDoc.Confirmation(
            back = { navHostController.popBackStack() },
            navigateToAppointmentSuccess = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.appointmentSuccess.path)
            },
            appointmentDate = appointmentDate,
            appointmentHours = appointmentHours
        )
    }
}

fun addAppointmentSuccessScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.appointmentSuccess.path
    ) {
        _root_ide_package_.com.example.medcare.screens.servicesScreen.chatDoc.AppointmentSuccess(
            navigateToHistory = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.History.path) {
                    popUpTo(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Services.path) {
                        _root_ide_package_.androidx.navigation.PopUpToBuilder.inclusive = true
                    }
                }
            }
        )
    }
}

fun addMedReminderScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.medReminder.path
    ) {
        _root_ide_package_.com.example.medcare.screens.medicationReminder.MedicationHome(
            back = { navHostController.popBackStack() },
            navigateToAddMed = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.addMed.path)
            }
        )
    }
}

fun addMedicineScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.addMed.path
    ) {
        _root_ide_package_.com.example.medcare.screens.medicationReminder.MedicationReminder(
            back = { navHostController.popBackStack() },
            navigateToSavedReminder = { medName, dosage, timings ->
                navHostController.navigate(
                    _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.savedReminder.path.plus(
                        "/$medName/$dosage/$timings"
                    )
                )
            }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun addSavedReminder(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.savedReminder.path.plus("/{medName}/{dosage}/{timings}"),
        arguments = listOf(
            navArgument("medName") {
                type = NavType.StringType
            },
            navArgument("dosage") {
                type = NavType.StringType
            },
            navArgument("timings") {
                type = NavType.StringType
            }
        )
    ) {
        val medName: String = it.arguments?.getString("medName").toString()
        val dosage: String = it.arguments?.getString("dosage").toString()
        val timings: String = it.arguments?.getString("timings").toString()
        _root_ide_package_.com.example.medcare.screens.medicationReminder.ReminderFilled(
            medName, dosage, timings,
            back = { navHostController.popBackStack() }
        )
    }
}

fun addSpecialistScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.specialist.path
    ) {
        _root_ide_package_.com.example.medcare.screens.specialization.Specialist(
            back = { navHostController.popBackStack() }
        )
    }
}

fun addArticleHome(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.articleHome.path
    ) {
        _root_ide_package_.com.example.medcare.screens.article.ArticleList(
            back = { navHostController.popBackStack() },
            navigateToArticle = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.articleRead.path)
            },
            navigateToArticleGrid = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.articleGrid.path)
            }
        )
    }
}

fun addReadArticleScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.articleRead.path
    ) {
        _root_ide_package_.com.example.medcare.screens.article.DisplayArticle(
            back = { navHostController.popBackStack() }
        )
    }
}

fun addArticleGridScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.articleGrid.path
    ) {
        _root_ide_package_.com.example.medcare.screens.article.ArticlePage(
            back = { navHostController.popBackStack() },
            navigateToArticle = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.articleRead.path)
            },
        )
    }
}

fun addFindPharmaScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.findingPharma.path
    ) {
        _root_ide_package_.com.example.medcare.screens.healthShop.cart.FindingPharmacy(
            navigateToEmptyCart = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.emptyCart.path)
            }
        )
    }
}

fun addEmptyCartScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.emptyCart.path
    ) {
        _root_ide_package_.com.example.medcare.screens.healthShop.cart.EmptyCart(
            back = { navHostController.popBackStack() },
            navigateToHealthShop = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.HealthShop.path) {
                    popUpTo(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.HealthShop.path) {
                        _root_ide_package_.androidx.navigation.PopUpToBuilder.inclusive = true
                    }
                }
            }
        )
    }
}

fun addPrescriptionHistScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.presHist.path
    ) {
        _root_ide_package_.com.example.medcare.screens.profile.PrescriptionHistory(
            back = { navHostController.popBackStack() }
        )
    }
}

fun addHealthHistScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.healthHist.path
    ) {
        _root_ide_package_.com.example.medcare.screens.profile.HealthHistory(
            back = { navHostController.popBackStack() }
        )
    }
}

fun addTransactionScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.transactions.path
    ) {
        _root_ide_package_.com.example.medcare.screens.profile.Transactions(
            back = { navHostController.popBackStack() }
        )
    }
}

fun addAccSettScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.accSett.path
    ) {
        _root_ide_package_.com.example.medcare.screens.profile.AccountSettings(
            back = { navHostController.popBackStack() }
        )
    }
}

fun addClearNotiScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.clearNoti.path
    ) {
        _root_ide_package_.com.example.medcare.screens.profile.EmptyNotifications(
            navigateToHome = {
                navHostController.navigate(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Main.path) {
                    popUpTo(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Main.path) {
                        _root_ide_package_.androidx.navigation.PopUpToBuilder.inclusive = true
                    }
                }
            }
        )
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