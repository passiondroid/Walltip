package com.walltip.repository.data.source.model


import com.squareup.moshi.Json

data class UnsplashResult(
    @Json(name = "results")
    val results: List<Result>,
    @Json(name = "total")
    val total: Int,
    @Json(name = "total_pages")
    val totalPages: Int
) {
     class Result(
        @Json(name = "alt_description")
        val altDescription: String?,
        @Json(name = "color")
        val color: String?,
        @Json(name = "created_at")
        val createdAt: String?,
        @Json(name = "description")
        val description: String?,
        @Json(name = "height")
        val height: Int?,
        @Json(name = "id")
        val id: String?,
        @Json(name = "liked_by_user")
        val likedByUser: Boolean?,
        @Json(name = "likes")
        val likes: Int?,
        @Json(name = "links")
        val links: Links?,
        @Json(name = "sponsored")
        val sponsored: Boolean?,
        @Json(name = "tags")
        val tags: List<Tag?>?,
        @Json(name = "updated_at")
        val updatedAt: String?,
        @Json(name = "urls")
        val urls: Urls?,
        @Json(name = "user")
        val user: User?,
        @Json(name = "width")
        val width: Int?
    ) {
        data class Tag(
            @Json(name = "title")
            val title: String?
        )

        data class User(
            @Json(name = "accepted_tos")
            val acceptedTos: Boolean?,
            @Json(name = "bio")
            val bio: String?,
            @Json(name = "first_name")
            val firstName: String?,
            @Json(name = "id")
            val id: String?,
            @Json(name = "instagram_username")
            val instagramUsername: String?,
            @Json(name = "links")
            val links: Links?,
            @Json(name = "location")
            val location: String?,
            @Json(name = "name")
            val name: String?,
            @Json(name = "portfolio_url")
            val portfolioUrl: String?,
            @Json(name = "profile_image")
            val profileImage: ProfileImage?,
            @Json(name = "total_collections")
            val totalCollections: Int?,
            @Json(name = "total_likes")
            val totalLikes: Int?,
            @Json(name = "total_photos")
            val totalPhotos: Int?,
            @Json(name = "twitter_username")
            val twitterUsername: String?,
            @Json(name = "updated_at")
            val updatedAt: String?,
            @Json(name = "username")
            val username: String?
        ) {
            data class ProfileImage(
                @Json(name = "large")
                val large: String?,
                @Json(name = "medium")
                val medium: String?,
                @Json(name = "small")
                val small: String?
            )

            data class Links(
                @Json(name = "followers")
                val followers: String?,
                @Json(name = "following")
                val following: String?,
                @Json(name = "html")
                val html: String?,
                @Json(name = "likes")
                val likes: String?,
                @Json(name = "photos")
                val photos: String?,
                @Json(name = "portfolio")
                val portfolio: String?,
                @Json(name = "self")
                val self: String?
            )
        }

        data class Links(
            @Json(name = "download")
            val download: String?,
            @Json(name = "download_location")
            val downloadLocation: String?,
            @Json(name = "html")
            val html: String?,
            @Json(name = "self")
            val self: String?
        )

        data class Urls(
            @Json(name = "full")
            val full: String?,
            @Json(name = "raw")
            val raw: String?,
            @Json(name = "regular")
            val regular: String?,
            @Json(name = "small")
            val small: String?,
            @Json(name = "thumb")
            val thumb: String?
        )
    }
}