package com.example.storeapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products_table")
public class ProductModelRoom {

    @PrimaryKey
        private Integer id;

        private String title;

        private Double price;

        private String description;

        private String category;

        private String image;



        public ProductModelRoom() {
        }

        public ProductModelRoom(Integer id, String title, Double price, String description, String category, String image) {
            super();
            this.id = id;
            this.title = title;
            this.price = price;
            this.description = description;
            this.category = category;
            this.image = image;
        }


        public Integer getId() {
            return id;
        }


        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }


        public String getCategory() {
            return category;
        }


        public void setCategory(String category) {
            this.category = category;
        }


        public String getImage() {
            return image;
        }


        public void setImage(String image) {
            this.image = image;
        }

}

