package com.example.medcare.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.medcare.article.ArticleList
import com.example.medcare.article.ArticlePage
import com.example.medcare.article.DisplayArticle
import com.example.medcare.class_objects.HospitalData
import com.example.medcare.healthShop.Home.ShoppingHomePage
import com.example.medcare.healthShop.MedicineDescription
import com.example.medcare.healthShop.MedicineGrid
import com.example.medcare.healthShop.cart.Cart
import com.example.medcare.healthShop.cart.EmptyCart
import com.example.medcare.healthShop.cart.FindingPharmacy
import com.example.medcare.history.HistoryScreen
import com.example.medcare.homeScreen.HomeScreen
import com.example.medcare.hospitals.HospitalDetails
import com.example.medcare.hospitals.HospitalMain
import com.example.medcare.hospitals.Map
import com.example.medcare.medicationReminder.MedicationHome
import com.example.medcare.medicationReminder.MedicationReminder
import com.example.medcare.medicationReminder.ReminderFilled
import com.example.medcare.profile.AccountSettings
import com.example.medcare.profile.EmptyNotifications
import com.example.medcare.profile.HealthHistory
import com.example.medcare.profile.NotificationScreen
import com.example.medcare.profile.PrescriptionHistory
import com.example.medcare.profile.ProfileScreen
import com.example.medcare.profile.Transactions
import com.example.medcare.profile.pharma.AdminCred
import com.example.medcare.profile.pharma.RegisterPharma
import com.example.medcare.servicesScreen.ServicesScreen
import com.example.medcare.servicesScreen.chatDoc.AppointmentSuccess
import com.example.medcare.servicesScreen.chatDoc.ChatDoctorScreen
import com.example.medcare.servicesScreen.chatDoc.Confirmation
import com.example.medcare.servicesScreen.chatDoc.DoctorDetails
import com.example.medcare.specialization.Specialist
import com.example.medcare.splashScreen.AuthSplashScreen
import com.example.medcare.splashScreen.hPager
import com.example.medcare.splashScreen.splashscreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(navHostController: NavHostController, modifier: Modifier) {
    NavHost(navHostController, startDestination = NavRoute.Splash.path) {
        addHomeScreen(navHostController, this)
        addSplashScreen(navHostController, this)
        addWalkthroughScreen(navHostController,this)
        addProfileScreen(navHostController,this)
        addHistoryScreen(navHostController,this)
        addServicesScreen(navHostController,this)
        addAuthSplash(navHostController,this)
        addChatDocScreen(navHostController,this)
        addNotificationsScreen(navHostController,this)
        addClearNotiScreen(navHostController,this)
        addCartScreen(navHostController,this)
        addFindPharmaScreen(navHostController,this)
        addEmptyCartScreen(navHostController,this)
        addHealthShop(navHostController,this)
        addMedGrid(navHostController,this)
        addMedDesc(navHostController,this)
        addDocDtls(navHostController,this)
        addAppointmentScreen(navHostController,this)
        addAppointmentSuccessScreen(navHostController,this)
        addHospiDetailsScreen(navHostController,this)
        addHospitalScreen(navHostController,this)
        addHospiLocScreen(navHostController,this)
        addMedReminderScreen(navHostController,this)
        addMedicineScreen(navHostController,this)
        addSpecialistScreen(navHostController,this)
        addArticleHome(navHostController,this)
        addReadArticleScreen(navHostController,this)
        addArticleGridScreen(navHostController,this)
        addPrescriptionHistScreen(navHostController,this)
        addHealthHistScreen(navHostController,this)
        addTransactionScreen(navHostController,this)
        addAccSettScreen(navHostController,this)
        addPharmacyPortalScreen(navHostController,this)
        addPharmaRegisterScreen(navHostController,this)
        addSavedReminder(navHostController,this)
    }
}

fun addHomeScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder)  {
    navGraphBuilder.composable(
        route = NavRoute.Main.path
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
            }
        )
    }
}
fun addSplashScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Splash.path
    ) {
        splashscreen(
            navigateToOnBoard = {
                navHostController.navigate(NavRoute.Walkthrough.path)
            },
            navigateToHome = {
                navHostController.navigate(NavRoute.Main.path)
            }
        )
    }
}

fun addWalkthroughScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Walkthrough.path
    ) {
        hPager(navigateToAuthSplash = {
            navHostController.navigate(NavRoute.AuthSplash.path)
        })
    }
}

fun addProfileScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Profile.path,
//        arguments = listOf(
//            navArgument("userName") {
//                type = NavType.StringType
//            }
//        )
    ) {

//        val userName = it.arguments?.getString("userName").toString()
        ProfileScreen(
            back = {navHostController.popBackStack()},
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
            navigateToPharmaAdmin = {
                navHostController.navigate(NavRoute.pharmaPortal.path)
            }
//            userName
        )
    }
}

fun addServicesScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Services.path
    ) {
        ServicesScreen(back = { navHostController.popBackStack() },
            navHostController)
    }
}

fun addHistoryScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.History.path
    ) {
        HistoryScreen(back = {navHostController.popBackStack()})
    }
}

fun addAuthSplash(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.AuthSplash.path
    ) {
        AuthSplashScreen()
    }
}

fun addChatDocScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.ChatDoc.path
    ) {
        ChatDoctorScreen(
            back = {navHostController.popBackStack()},
            navigateToDocDtls = {
                navHostController.navigate(NavRoute.DocDtls.path)
            }
        )
    }
}

fun addNotificationsScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Notifications.path
    ) {
        NotificationScreen(
            back = {navHostController.popBackStack()},
            navigateToClearNotifications = {
                navHostController.navigate(NavRoute.clearNoti.path)
            }
        )
    }
}

fun addCartScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Cart.path
    ) {
        Cart(
            back = {navHostController.popBackStack()},
            navigateToFindingPharma = {
                navHostController.navigate(NavRoute.findingPharma.path)
            }
        )
    }
}

fun addHealthShop(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.HealthShop.path
    ) {
        ShoppingHomePage(
            back = {navHostController.popBackStack()},
            navigateToMedGrid = {
                navHostController.navigate(NavRoute.medGrid.path)
            },
            navigateToMedDesc = {
                navHostController.navigate(NavRoute.medDesc.path)
            },
            navigateToCart = {
                navHostController.navigate(NavRoute.Cart.path)
            }
        )
    }
}

fun addMedGrid(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.medGrid.path
    ) {
        MedicineGrid(
            back = {navHostController.popBackStack()},
            navigateToMedDesc = {
                navHostController.navigate(NavRoute.medDesc.path)
            },
            navigateToCart = {
                navHostController.navigate(NavRoute.Cart.path)
            }
        )
    }
}

fun addMedDesc(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.medDesc.path
    ) {
        MedicineDescription(
            back = {navHostController.popBackStack()},
            navigateToCart = {
                navHostController.navigate(NavRoute.Cart.path)
            }
        )
    }
}

fun addHospitalScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.hospital.path
    ) {

        HospitalMain(
            back = {navHostController.popBackStack()},
            navigateToDetail = {
                navHostController.navigate(NavRoute.hospiDtls.path)
            },
            navigateToMap = {
                navHostController.navigate(NavRoute.hospiMap.path)
            }
        )
    }
}

fun addHospiDetailsScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.hospiDtls.path
    ) {
        val item = HospitalData.data.first()
        HospitalDetails(item,
            navigateToMap = {
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
        route = NavRoute.DocDtls.path
    ) {
        DoctorDetails(
            back = {navHostController.popBackStack()},
            navigateToAppointment = { navHostController.navigate(NavRoute.Appointment.path) }
        )
    }
}


fun addAppointmentScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Appointment.path
    ) {
        Confirmation(
            back = { navHostController.popBackStack() },
            navigateToAppointmentSuccess = {
                navHostController.navigate(NavRoute.appointmentSuccess.path)
            }
        )
    }
}

fun addAppointmentSuccessScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.appointmentSuccess.path
    ) {
        AppointmentSuccess(
            navigateToHistory = {
                navHostController.navigate(NavRoute.History.path) {
                    popUpTo(NavRoute.Services.path) {
                        inclusive = true
                    }
                }
            }
        )
    }
}
fun addMedReminderScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.medReminder.path
    ) {
        MedicationHome(
            back = {navHostController.popBackStack()},
            navigateToAddMed = {
                navHostController.navigate(NavRoute.addMed.path)
            }
        )
    }
}

fun addMedicineScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.addMed.path
    ) {
        MedicationReminder(
            back = {navHostController.popBackStack()},
            navigateToSavedReminder = {
                medName, dosage, timings ->
                navHostController.navigate(NavRoute.savedReminder.path.plus("/$medName/$dosage/$timings"))
            }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun addSavedReminder(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.savedReminder.path.plus("/{medName}/{dosage}/{timings}"),
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
        ReminderFilled(medName,dosage,timings,
            back = {navHostController.popBackStack()}
        )
    }
}

fun addSpecialistScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.specialist.path
    ) {
        Specialist(
            back = {navHostController.popBackStack()}
        )
    }
}

fun addArticleHome(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.articleHome.path
    ) {
        ArticleList(
            back = {navHostController.popBackStack()},
            navigateToArticle = {
                navHostController.navigate(NavRoute.articleRead.path)
            },
            navigateToArticleGrid = {
                navHostController.navigate(NavRoute.articleGrid.path)
            }
        )
    }
}

fun addReadArticleScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.articleRead.path
    ) {
        DisplayArticle(
            back = { navHostController.popBackStack() }
        )
    }
}

fun addArticleGridScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.articleGrid.path
    ) {
        ArticlePage(
            back = {navHostController.popBackStack()},
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
            }
        )
    }
}

fun addEmptyCartScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.emptyCart.path
    ) {
        EmptyCart(
            back = { navHostController.popBackStack() },
            navigateToHealthShop = {
                navHostController.navigate(NavRoute.HealthShop.path){
                    popUpTo(NavRoute.HealthShop.path) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

fun addPrescriptionHistScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.presHist.path
    ) {
        PrescriptionHistory(
            back = {navHostController.popBackStack()}
        )
    }
}

fun addHealthHistScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.healthHist.path
    ) {
        HealthHistory(
            back = {navHostController.popBackStack()}
        )
    }
}

fun addTransactionScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.transactions.path
    ) {
        Transactions(
            back = {navHostController.popBackStack()}
        )
    }
}

fun addAccSettScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.accSett.path
    ) {
        AccountSettings(
            back = {navHostController.popBackStack()}
        )
    }
}

fun addClearNotiScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.clearNoti.path
    ) {
        EmptyNotifications()
    }
}

fun addPharmacyPortalScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.pharmaPortal.path
    ) {
        AdminCred(
            navigateToPharmaRegister = {
                navHostController.navigate(NavRoute.pharmaRegister.path)
            }
        )
    }
}

fun addPharmaRegisterScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.pharmaRegister.path
    ) {
        RegisterPharma()
    }
}